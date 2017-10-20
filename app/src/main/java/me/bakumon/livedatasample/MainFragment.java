package me.bakumon.livedatasample;

import android.arch.lifecycle.Observer;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.bakumon.livedatasample.databinding.FragmentMainBinding;

/**
 * Created by Bakumon on 2017/10/20.
 */

public class MainFragment extends Fragment {
    public static final String TAG = MainFragment.class.getSimpleName();

    private FragmentMainBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        MainViewModel mainViewModel = new MainViewModel();

        mainViewModel.getProducts().observe(this, new Observer<MainEntry>() {
            @Override
            public void onChanged(@Nullable MainEntry mainEntry) {
                if (mainEntry != null) {
                    mBinding.tvName.setText(mainEntry.name);
                }
            }
        });


        MainEntry entry = new MainEntry();
        entry.name = "changed";
        mainViewModel.getProducts().setValue(entry);
    }
}
