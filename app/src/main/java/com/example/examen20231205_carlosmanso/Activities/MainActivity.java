package com.example.examen20231205_carlosmanso.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.examen20231205_carlosmanso.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    void init(View v){
        Intent i = new Intent(this, Chrono.class);
        startActivity(i);
    }

    void quit (){
        finish();
    }
}