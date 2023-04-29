package com.example.common;

import android.app.Application;

import com.example.common.utils.MSP;

public abstract class App_Parent extends Application {

    protected static Class<?> statsClass;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeStatsClass();
       // MySignalV2.initHelper(this);
        MSP.initHelper(this);
    }

    protected void initializeStatsClass() {
        // Do nothing by default
    }
}
