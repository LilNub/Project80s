package com.example.project80s;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Shop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        getWindow().setStatusBarColor(Color.WHITE);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        TextView tvsoap = findViewById(R.id.textsoap);
        Button add1 = findViewById(R.id.add1);
        Button wish1 = findViewById(R.id.wish1);
        TextView tvperfume = findViewById(R.id.textperfume);
        Button add2 = findViewById(R.id.add2);
        Button wish2 = findViewById(R.id.wish2);
        TextView tvkit = findViewById(R.id.textkit);
        Button add3 = findViewById(R.id.add3);
        Button wish3 = findViewById(R.id.wish3);
        tvsoap.setVisibility(View.GONE);
        add1.setVisibility(View.GONE);
        wish1.setVisibility(View.GONE);
        tvperfume.setVisibility(View.GONE);
        add2.setVisibility(View.GONE);
        wish2.setVisibility(View.GONE);
        tvkit.setVisibility(View.GONE);
        add3.setVisibility(View.GONE);
        wish3.setVisibility(View.GONE);
        ImageButton soap = findViewById(R.id.soap);
        soap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tvsoap.getVisibility() == View.GONE){
                   tvsoap.setVisibility(View.VISIBLE);
                   add1.setVisibility(View.VISIBLE);
                   wish1.setVisibility(View.VISIBLE);
                }else if (tvsoap.getVisibility() == View.VISIBLE){
                    tvsoap.setVisibility(View.GONE);
                    add1.setVisibility(View.GONE);
                    wish1.setVisibility(View.GONE);
                }
            }
        });
        ImageButton perf = findViewById(R.id.perf);
        perf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tvperfume.getVisibility() == View.GONE){
                    tvperfume.setVisibility(View.VISIBLE);
                    add2.setVisibility(View.VISIBLE);
                    wish2.setVisibility(View.VISIBLE);
                }else if (tvperfume.getVisibility() == View.VISIBLE){
                    tvperfume.setVisibility(View.GONE);
                    add2.setVisibility(View.GONE);
                    wish2.setVisibility(View.GONE);
                }
            }
        });
        ImageButton kit = findViewById(R.id.kit);
        kit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvkit.getVisibility() == View.GONE) {
                    tvkit.setVisibility(View.VISIBLE);
                    add3.setVisibility(View.VISIBLE);
                    wish3.setVisibility(View.VISIBLE);
                } else if (tvkit.getVisibility() == View.VISIBLE) {
                    tvkit.setVisibility(View.GONE);
                    add3.setVisibility(View.GONE);
                    wish3.setVisibility(View.GONE);
                }
            }
        });
    }


}
