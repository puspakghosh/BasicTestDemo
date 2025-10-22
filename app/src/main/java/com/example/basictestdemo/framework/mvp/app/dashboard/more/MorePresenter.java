package com.example.basictestdemo.framework.mvp.app.dashboard.more;

import android.os.Handler;
import android.os.Looper;

import com.example.basictestdemo.framework.mvp.app.dashboard.benefits.BenefitsContract;
import com.example.basictestdemo.framework.mvp.app.dashboard.home.HomeContract;
import com.example.basictestdemo.framework.mvp.app.dashboard.model.DataItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MorePresenter implements HomeContract.Presenter {
    private MoreContract.View view;

    public MorePresenter(MoreContract.View view) {
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
                items.add(new DataItem("My Account", "https://yavuzceliker.github.io/sample-images/image-" + new Random().nextInt(1000) + ".jpg"));
                items.add(new DataItem("App Settings", "https://yavuzceliker.github.io/sample-images/image-" + new Random().nextInt(1000) + ".jpg"));
                items.add(new DataItem("Help & FAQ", "https://yavuzceliker.github.io/sample-images/image-" + new Random().nextInt(1000) + ".jpg"));
                items.add(new DataItem("Privacy Policy", "https://yavuzceliker.github.io/sample-images/image-" + new Random().nextInt(1000) + ".jpg"));
                items.add(new DataItem("Logout", "https://yavuzceliker.github.io/sample-images/image-" + new Random().nextInt(1000) + ".jpg"));
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

