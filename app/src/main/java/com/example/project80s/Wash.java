package com.example.project80s;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project80s.CRUD.Data_Order;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Wash extends AppCompatActivity {
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private String nama[] = {"Woman Shoes Treatment", "Sneakers Shoes Treatment", "Leather Gentleman Care", "Bag Care Treatment"};
    private String jenis = "Care and Treatment";
    private String harga[] = {"20.000", "15.000","25.000","10.000"};
    ImageButton women,sneaker,leather,bag;
    TextView tvwoman,tvsneaker,tvgentle,tvbag;
    Button wish1,wish2,wish3,wish4;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference getReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wash);
        String userID = user.getUid();
        getReference = database.getReference();
        getWindow().setStatusBarColor(Color.WHITE);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

         women = findViewById(R.id.women);
         sneaker = findViewById(R.id.sneakers);
         leather = findViewById(R.id.gentle);
         bag = findViewById(R.id.bag);

         tvwoman = findViewById(R.id.tvwomen);
         tvsneaker = findViewById(R.id.tvsneaker);
         tvgentle = findViewById(R.id.tvleather);
         tvbag = findViewById(R.id.tvbag);

         wish1 = findViewById(R.id.wish1);
         wish2 = findViewById(R.id.wish2);
         wish3 = findViewById(R.id.wish3);
         wish4 = findViewById(R.id.wish4);

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
                    wish1.setVisibility(View.VISIBLE);
                }else if (tvwoman.getVisibility() == View.VISIBLE){
                    tvwoman.setVisibility(View.GONE);
                    wish1.setVisibility(View.GONE);
                }
            }
        });

        sneaker.setOnClickListener(v -> {
            if(tvsneaker.getVisibility() == View.GONE){
                tvsneaker.setVisibility(View.VISIBLE);
                wish2.setVisibility(View.VISIBLE);
            }else if (tvsneaker.getVisibility() == View.VISIBLE){
                tvsneaker.setVisibility(View.GONE);
                wish2.setVisibility(View.GONE);
            }
        });

        leather.setOnClickListener(v -> {
            if(tvgentle.getVisibility() == View.GONE){
                tvgentle.setVisibility(View.VISIBLE);
                wish3.setVisibility(View.VISIBLE);
            }else if (tvgentle.getVisibility() == View.VISIBLE){
                tvgentle.setVisibility(View.GONE);
                wish3.setVisibility(View.GONE);
            }
        });

        bag.setOnClickListener(v -> {
            if(tvbag.getVisibility() == View.GONE){
                tvbag.setVisibility(View.VISIBLE);
                wish4.setVisibility(View.VISIBLE);
            }else if (tvbag.getVisibility() == View.VISIBLE){
                tvbag.setVisibility(View.GONE);
                wish4.setVisibility(View.GONE);
            }
        });

        wish1.setOnClickListener(v -> {
            getReference.child("Admin").child(userID).child("Order_Shop").push()
                    .setValue(new Data_Order(nama[0],jenis,harga[0]))
                    .addOnSuccessListener(Wash.this,
                            aVoid -> Toast.makeText(Wash.this, "Berhasil Ditambahkan",
                                    Toast.LENGTH_SHORT).show());
        });

        wish2.setOnClickListener(v -> {
            getReference.child("Admin").child(userID).child("Order_Shop").push()
                    .setValue(new Data_Order(nama[1],jenis,harga[1]))
                    .addOnSuccessListener(Wash.this,
                            aVoid -> Toast.makeText(Wash.this, "Berhasil Ditambahkan",
                                    Toast.LENGTH_SHORT).show());
        });

        wish3.setOnClickListener(v -> {
            getReference.child("Admin").child(userID).child("Order_Shop").push()
                    .setValue(new Data_Order(nama[2],jenis,harga[2]))
                    .addOnSuccessListener(Wash.this,
                            aVoid -> Toast.makeText(Wash.this, "Berhasil Ditambahkan",
                                    Toast.LENGTH_SHORT).show());
        });

        wish4.setOnClickListener(v -> {
            getReference.child("Admin").child(userID).child("Order_Shop").push()
                    .setValue(new Data_Order(nama[3],jenis,harga[3]))
                    .addOnSuccessListener(Wash.this,
                            aVoid -> Toast.makeText(Wash.this, "Berhasil Ditambahkan",
                                    Toast.LENGTH_SHORT).show());
        });
    }

}
