package com.example.basictestdemo.framework.mvp.app.dashboard.home;

import com.example.basictestdemo.framework.mvp.app.dashboard.model.DataItem;

import java.util.List;

public interface HomeContract {
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
