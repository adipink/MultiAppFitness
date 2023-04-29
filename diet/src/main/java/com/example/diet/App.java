package com.example.diet;

import com.example.common.App_Parent;

public class App extends App_Parent {

    @Override
    public void onCreate() {
        super.onCreate();
        statsClass = MainActivity.class;
        initializeStatsClass();
    }

    @Override
    protected void initializeStatsClass() {
        if (statsClass == null) {
            // Default to MainActivity if statsClass is null
            statsClass = MainActivity.class;
        }
    }
}
