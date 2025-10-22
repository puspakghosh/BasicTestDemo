package com.example.basictestdemo.framework.mvp.app.dashboard.benefits;

import android.os.Handler;
import android.os.Looper;

import com.example.basictestdemo.framework.mvp.app.dashboard.home.HomeContract;
import com.example.basictestdemo.framework.mvp.app.dashboard.model.DataItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BenefitsPresenter implements HomeContract.Presenter {
    private BenefitsContract.View view;

    public BenefitsPresenter(BenefitsContract.View view) {
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
                items.add(new DataItem("Health Benefits", "https://yavuzceliker.github.io/sample-images/image-" + new Random().nextInt(1000) + ".jpg"));
                items.add(new DataItem("Travel Vouchers","https://yavuzceliker.github.io/sample-images/image-" + new Random().nextInt(1000) + ".jpg"));
                items.add(new DataItem("Plans Discounts", "https://yavuzceliker.github.io/sample-images/image-" + new Random().nextInt(1000) + ".jpg"));
                items.add(new DataItem("More Plans","https://yavuzceliker.github.io/sample-images/image-" + new Random().nextInt(1000) + ".jpg"));
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

