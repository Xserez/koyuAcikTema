package com.example.koyuaciktema;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.RadioButton;


public class MainActivity extends AppCompatActivity {

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;
    public String tema="";
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioButton mRadioButton1 = findViewById(R.id.radioAcik);
        RadioButton mRadioButton2 = findViewById(R.id.radioKaranlik);


        if (!mPreferences.contains("tema")) {
            mEditor.putInt("tema", AppCompatDelegate.MODE_NIGHT_NO);
            mEditor.apply();
        }

;
        if (tema == AppCompatDelegate.MODE_NIGHT_NO) {
            mRadioButton1.setChecked(true);
        } else {
            mRadioButton2.setChecked(true);
        }

        public void onRadioClicked(View view){
            boolen checked=((RadioButton)view).isChecked();
            switch (view.getId()){
                case R.id.radioAcik:
                    if (checked){
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        mEditor.putInt("tema", AppCompatDelegate.MODE_NIGHT_NO);
                        mEditor.apply();
                    }
                    break;
                case R.id.radioKaranlik:
                    if(checked){
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        mEditor.putInt("tema", AppCompatDelegate.MODE_NIGHT_YES);
                        mEditor.apply();
                    }
                    break;
            }
        }
        protected void onDestroy() {
            mPreferences=null;
            super.onDestroy();
        }

    }
}