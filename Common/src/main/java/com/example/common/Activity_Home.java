package com.example.common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.common.utils.MSP;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
import java.util.List;

public class Activity_Home extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextView home_TXT_title,home_TXT_intro;
    private Spinner home_SP_count;
    private AppCompatTextView home_TXT_option1,home_TXT_option2;
    private MaterialTextView home_TXT_stats;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findViews();
        createSpinner();
        createListeners();

    }

    private void createListeners() {
        home_SP_count.setOnItemSelectedListener(this);
        home_TXT_option1.setOnClickListener(v-> option1Selected());
        home_TXT_option2.setOnClickListener(v-> option2Selected());
        home_TXT_stats.setOnClickListener(v->statsClicked());

    }

    private void option1Selected() {
        home_TXT_option1.setBackgroundResource(R.color.selected);
        home_TXT_option2.setBackgroundResource(R.color.spinner_2);
        MSP.getInstance().putString("PURPOSE", home_TXT_option1.getText().toString());
    }
    private void option2Selected() {
        home_TXT_option2.setBackgroundResource(R.color.selected);
        home_TXT_option1.setBackgroundResource(R.color.spinner_1);
        MSP.getInstance().putString("PURPOSE", home_TXT_option2.getText().toString());
    }

    private void statsClicked() {
        startActivity(new Intent(this, App_Parent.statsClass));
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        String parameter = adapterView.getItemAtPosition(position).toString();
        int i = parameter.indexOf(' ');
        String word;
        if (i >= 0) {
            word = parameter.substring(0, i);
            //MSP.getInstance().putString("COUNT", word);
        } else {
            word = parameter.toString();
            // handle case where parameter does not contain a space character
        }
        //String word = parameter.substring(0, i);
       MSP.getInstance().putString("COUNT", word);
    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void createSpinner() {

        List<String> list = new ArrayList<>();
        for (int i=1; i<=10; i++){
            list.add(""+ i);
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                R.layout.spinner_list, list);
        dataAdapter.setDropDownViewResource(R.layout.spinner_list);
        home_SP_count.setAdapter(dataAdapter);
        home_SP_count.setSelection(0);
    }

    private void findViews() {
        home_TXT_title = findViewById(R.id.home_TXT_title);
        home_TXT_intro = findViewById(R.id.home_TXT_intro);
        home_SP_count = findViewById(R.id.home_SP_count);
        home_TXT_option1 = findViewById(R.id.home_TXT_option1);
        home_TXT_option2 = findViewById(R.id.home_TXT_option2);
        home_TXT_stats = findViewById(R.id.home_TXT_stats);



    }
}