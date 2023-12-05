package com.example.examen20231205_carlosmanso.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.examen20231205_carlosmanso.Handlers.Count_adapter;
import com.example.examen20231205_carlosmanso.Handlers.Count_handler;
import com.example.examen20231205_carlosmanso.R;

import java.util.ArrayList;
import java.util.List;


public class Chrono extends AppCompatActivity {
    boolean ok = false;
    boolean fs = false;
    TextView counter;
    int secs = 0 ;
    int prev = 0 ;
    List<Count_handler> l;
    RecyclerView rv;
//    Thread inc = new Thread(() -> {
//        synchronized (this){
//            while(true) {
//                if(!ok){
//                    try {
//                        wait();
//                    } catch (InterruptedException e) {}
//                }
//                try {
//                    Thread.sleep(1000);
//                } catch (Exception e) {}
//                runOnUiThread(() -> counter.setText(formatHours(""+(++secs))));
//            }
//        }
//    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chrono);
        counter = (TextView) findViewById(R.id.Counter);

        rv = (RecyclerView) findViewById(R.id.rv_count);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        l = new ArrayList<Count_handler>();
    }

    void initChrono (View v){
        if (!fs){
            //inc.start();
            fs=true;
        }
        if(!ok) notify();
        ok = true;
    }

    synchronized void pauseChrono (){
        ok = ok ? false : ok;
    }

    void record (View v){
        l.add(new Count_handler(""+(secs-prev)));
        rv.setAdapter(new Count_adapter(l));
        prev = secs;
    }

    String formatHours(String s) {
        int t = Integer.parseInt(s);
        int m = 0;
        int h = 0;

        if (t > 59) {
            m = t / 60;
            t = t - m * 60;
            if (m > 59) {
                h = m / 60;
                m = t - m * 60;
                t = Integer.parseInt(s) - (t * 60 * 60 + m * 60);
            }
        }
        return h + ":" + m + ":" + t;
    }

}