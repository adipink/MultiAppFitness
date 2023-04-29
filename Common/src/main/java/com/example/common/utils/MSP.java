package com.example.common.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class MSP {

    private static MSP instance;
    private SharedPreferences prefs;

    public static MSP getInstance() {
        return instance;
    }

    private MSP(Context context) {
        prefs = context.getApplicationContext().getSharedPreferences("APP_SP_DB", Context.MODE_PRIVATE);
    }


    public static MSP initHelper(Context context) {
        if (instance == null) instance = new MSP(context);
        return instance;
    }


    public void putInt(String KEY, int value) {
        prefs.edit().putInt(KEY, value).apply();
    }

    public int getInt(String KEY, int defValue) {
        return prefs.getInt(KEY, defValue);
    }

    public void putString(String KEY, String value) {
        prefs.edit().putString(KEY, value).apply();
    }

    public String getString(String KEY, String defvalue) {
        return prefs.getString(KEY, defvalue);
    }

}
