package com.example.diet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.common.Activity_Stats_Parent;
import com.example.common.utils.MSP;

public class MainActivity extends Activity_Stats_Parent {

    @Override
    protected String getData() {

        String numberOfVegetables = String.valueOf(MSP.getInstance().getString("COUNT", "1"));
        String dietPurpose = String.valueOf(MSP.getInstance().getString("PURPOSE","no purpose"));
        StringBuffer buffer = new StringBuffer();
        buffer.append("You ate "+ numberOfVegetables + " Vegetables");
        buffer.append("\n");
        buffer.append("Your purpose is " + dietPurpose);
        String result = buffer.toString();
        return result;
    }
}