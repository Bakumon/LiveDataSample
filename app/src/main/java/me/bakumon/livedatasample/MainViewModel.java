package me.bakumon.livedatasample;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by Bakumon on 2017/10/20.
 */

public class MainViewModel extends ViewModel {

    private MutableLiveData<MainEntry> mObservableEntry;

    public MutableLiveData<MainEntry> getProducts() {
        if (mObservableEntry == null) {
            mObservableEntry = new MutableLiveData<>();
            loadData();
        }
        return mObservableEntry;
    }

    // 这里可以进行网络请求
    private void loadData() {
        MainEntry entry = new MainEntry();
        entry.name = "lisi";
        mObservableEntry.setValue(entry);
    }

}
