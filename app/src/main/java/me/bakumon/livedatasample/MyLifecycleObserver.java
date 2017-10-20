package me.bakumon.livedatasample;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

/**
 * Created by Bakumon on 2017/10/20.
 */

public class MyLifecycleObserver implements LifecycleObserver {
    private static final String TAG = MyLifecycleObserver.class.getSimpleName();

    private Lifecycle mLifecycle;

    public MyLifecycleObserver(Lifecycle lifecycle) {
        this.mLifecycle = lifecycle;
        lifecycle.addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        Log.d(TAG, "onCreate: ");
        test();
    }

    public void test() {
        if (mLifecycle.getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
            Log.d(TAG, "CREATED: ");
        }
    }
}
