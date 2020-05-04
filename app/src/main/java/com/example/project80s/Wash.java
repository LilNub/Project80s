package com.example.project80s;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Wash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wash);
        getWindow().setStatusBarColor(Color.WHITE);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        ImageButton women = findViewById(R.id.women);
        ImageButton sneaker = findViewById(R.id.sneakers);
        ImageButton leather = findViewById(R.id.gentle);
        ImageButton bag = findViewById(R.id.bag);


        TextView tvwoman = findViewById(R.id.tvwomen);
        TextView tvsneaker = findViewById(R.id.tvsneaker);
        TextView tvgentle = findViewById(R.id.tvleather);
        TextView tvbag = findViewById(R.id.tvbag);

        Button add1 = findViewById(R.id.add1);
        Button add2 = findViewById(R.id.add2);
        Button add3 = findViewById(R.id.add3);
        Button add4 = findViewById(R.id.add4);

        Button wish1 = findViewById(R.id.wish1);
        Button wish2 = findViewById(R.id.wish2);
        Button wish3 = findViewById(R.id.wish3);
        Button wish4 = findViewById(R.id.wish4);

        add1.setVisibility(View.GONE);
        add2.setVisibility(View.GONE);
        add3.setVisibility(View.GONE);
        add4.setVisibility(View.GONE);

        tvwoman.setVisibility(View.GONE);
        tvsneaker.setVisibility(View.GONE);
        tvgentle.setVisibility(View.GONE);
        tvbag.setVisibility(View.GONE);

        wish1.setVisibility(View.GONE);
        wish2.setVisibility(View.GONE);
        wish3.setVisibility(View.GONE);
        wish4.setVisibility(View.GONE);

        women.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tvwoman.getVisibility() == View.GONE){
                    tvwoman.setVisibility(View.VISIBLE);
                    add1.setVisibility(View.VISIBLE);
                    wish1.setVisibility(View.VISIBLE);
                }else if (tvwoman.getVisibility() == View.VISIBLE){
                    tvwoman.setVisibility(View.GONE);
                    add1.setVisibility(View.GONE);
                    wish1.setVisibility(View.GONE);
                }
            }
        });

        sneaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tvsneaker.getVisibility() == View.GONE){
                    tvsneaker.setVisibility(View.VISIBLE);
                    add2.setVisibility(View.VISIBLE);
                    wish2.setVisibility(View.VISIBLE);
                }else if (tvsneaker.getVisibility() == View.VISIBLE){
                    tvsneaker.setVisibility(View.GONE);
                    add2.setVisibility(View.GONE);
                    wish2.setVisibility(View.GONE);
                }
            }
        });

        leather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tvgentle.getVisibility() == View.GONE){
                    tvgentle.setVisibility(View.VISIBLE);
                    add3.setVisibility(View.VISIBLE);
                    wish3.setVisibility(View.VISIBLE);
                }else if (tvgentle.getVisibility() == View.VISIBLE){
                    tvgentle.setVisibility(View.GONE);
                    add3.setVisibility(View.GONE);
                    wish3.setVisibility(View.GONE);
                }
            }
        });

        bag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tvbag.getVisibility() == View.GONE){
                    tvbag.setVisibility(View.VISIBLE);
                    add4.setVisibility(View.VISIBLE);
                    wish4.setVisibility(View.VISIBLE);
                }else if (tvbag.getVisibility() == View.VISIBLE){
                    tvbag.setVisibility(View.GONE);
                    add4.setVisibility(View.GONE);
                    wish4.setVisibility(View.GONE);
                }
            }
        });

    }

}
