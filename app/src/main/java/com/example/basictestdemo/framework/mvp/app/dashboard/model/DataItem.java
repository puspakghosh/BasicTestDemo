package com.example.basictestdemo.framework.mvp.app.dashboard.model;

public class DataItem {
    private String title;
    private String imageResUrl;

    public DataItem(String title, String imageResUrl) {
        this.title = title;
        this.imageResUrl = imageResUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getImageResUrl() {
        return imageResUrl;
    }
}

