package me.bakumon.livedatasample;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

/**
 * Created by Bakumon on 2017/10/20.
 */

public class MainViewModel extends ViewModel {

    private MutableLiveData<MainEntry> mObservableEntry;

    public MutableLiveData<MainEntry> getProducts() {
        // ♥♥ 使用 MutableLiveData 或 自定义 LiveData
        // 一般只需要使用 MutableLiveData 就行
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
        // ♥♥ 调用 setValue 或 postValue 更新 LiveData 中的 Data 数据，
        // 如果当前
        mObservableEntry.setValue(entry);
    }

    // ♥♥ 该 ViewModel 所在的 activity 或 fragment 销毁时回调该方法
    @Override
    protected void onCleared() {
        // 取消网络请求
        Log.e("MainViewModel", "onCleared: ");
    }
}
