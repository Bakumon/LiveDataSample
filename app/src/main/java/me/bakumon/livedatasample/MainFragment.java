package me.bakumon.livedatasample;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.bakumon.livedatasample.databinding.FragmentMainBinding;

/**
 *
 * Created by Bakumon on 2017/10/20.
 */

public class MainFragment extends Fragment {
    public static final String TAG = MainFragment.class.getSimpleName();

    private FragmentMainBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // ♥ 使用 DataBinding 只是为了方便实例化控件
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // ♥♥ 1. 这里必须使用 ViewModelProviders.of(this).get 的方式创建 ViewModel，
        //       否则该 ViewModel 不会和activity或fragment的声明周期关联，ViewModel#onCleared 方法不会被调用
        // ♥♥ 2. of 方法的参数，如果是 getActivity()，将会和宿主 activity 共享一个 ViewModel
//        final MainViewModel mainViewModel = new MainViewModel();
        final MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mainViewModel.getProducts().observe(this, new Observer<MainEntry>() {
            @Override
            public void onChanged(@Nullable MainEntry mainEntry) {
                if (mainEntry != null) {
                    mBinding.tvName.setText(mainEntry.name);
                }
            }
        });

        mBinding.btnSetValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainEntry entry = new MainEntry();
                entry.name = "changed";
                mainViewModel.getProducts().setValue(entry);
            }
        });

    }
}
