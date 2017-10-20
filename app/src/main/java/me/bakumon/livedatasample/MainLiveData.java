package me.bakumon.livedatasample;

import android.arch.lifecycle.LiveData;

/**
 * 自定义 LiveData
 * 通常 LiveData 不需要自定义，使用系统提供的 MutableLiveData 即可
 * Created by Bakumon on 2017/10/20.
 */

public class MainLiveData extends LiveData<MainEntry> {
    public MainLiveData() {

    }

    @Override
    protected void onActive() {
        super.onActive();
    }

    @Override
    protected void onInactive() {
        super.onInactive();
    }
}
