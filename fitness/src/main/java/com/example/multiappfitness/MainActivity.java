package com.example.multiappfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.common.Activity_Stats_Parent;
import com.example.common.utils.MSP;

public class MainActivity extends Activity_Stats_Parent {


    @Override
    protected String getData() {
        String numberOfKilometers = String.valueOf(MSP.getInstance().getString("COUNT", "1"));
        String fitnessPurpose = String.valueOf(MSP.getInstance().getString("PURPOSE","no purpose"));
        StringBuffer buffer = new StringBuffer();
        buffer.append("You ran "+ numberOfKilometers + " KM");
        buffer.append("\n");
        buffer.append("Your purpose is " + fitnessPurpose);
        String result = buffer.toString();
        return result;
    }
}