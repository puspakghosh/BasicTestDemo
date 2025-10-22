package com.example.basictestdemo.framework.mvp.app.dashboard.benefits;

import com.example.basictestdemo.framework.mvp.app.dashboard.model.DataItem;

import java.util.List;

public interface BenefitsContract {
    interface View {
        void showProgress();
        void hideProgress();
        void displayData(List<DataItem> items);
        void showMessage(String message);
    }

    interface Presenter {
        void fetchData();
        void detachView();
    }
}
