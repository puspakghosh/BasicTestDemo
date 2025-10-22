package com.example.basictestdemo.framework.mvp.app.dashboard.home;

import android.os.Handler;
import android.os.Looper;
import com.example.basictestdemo.R;
import com.example.basictestdemo.framework.mvp.app.dashboard.model.DataItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomePresenter implements HomeContract.Presenter {
    private HomeContract.View view;

    public HomePresenter(HomeContract.View view) {
        this.view = view;
    }

    @Override
    public void fetchData() {
        if (view == null) return;
        view.showProgress();

        // Simulate a network delay
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            if (view != null) {
                List<DataItem> items = new ArrayList<>();
                items.add(new DataItem("Welcome Home", "https://yavuzceliker.github.io/sample-images/image-" + new Random().nextInt(1000) + ".jpg"));
                items.add(new DataItem("Check your Profile","https://yavuzceliker.github.io/sample-images/image-" + new Random().nextInt(1000) + ".jpg"));
                items.add(new DataItem("Latest News", "https://yavuzceliker.github.io/sample-images/image-" + new Random().nextInt(1000) + ".jpg"));
                items.add(new DataItem("Settings","https://yavuzceliker.github.io/sample-images/image-" + new Random().nextInt(1000) + ".jpg"));
                view.hideProgress();
                view.displayData(items);
            }
        }, 1500); // 1.5-second delay
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}

