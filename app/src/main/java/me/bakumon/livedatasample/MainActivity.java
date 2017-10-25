package me.bakumon.livedatasample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ♥ 这里 LifecycleObserver 仅作为一个工具类来使用，不在架构中直接使用，
        // 由 LiveData 内部调用实现感知 Activity 和 Fragment 的生命周期

        // 使用 LifecycleObserver 管理该 Activity 的生命周期
        MyLifecycleObserver observer = new MyLifecycleObserver(getLifecycle());

        // 添加 MainFragment
        if (savedInstanceState == null) {
            MainFragment fragment = new MainFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, fragment, MainFragment.TAG).commit();
        }

    }
}
