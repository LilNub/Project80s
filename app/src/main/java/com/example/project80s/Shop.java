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

public class Shop extends AppCompatActivity {
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private String[] nama = {"Shoes Shop 80s Edition","Shoes Perfume 80s Edition","Shoes KitPack Care 80s Edition"};
    private String jenis = "Barang";
    private String[] harga = {"20.000","25.000","40.000"};
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    TextView tvsoap,tvperfume,tvkit;
    Button wish1,wish2,wish3;
    ImageButton soap,perf,kit;
    DatabaseReference getReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String userId = user.getUid();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        getReference = database.getReference();
        getWindow().setStatusBarColor(Color.WHITE);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
         tvsoap = findViewById(R.id.textsoap);
         wish1 = findViewById(R.id.wish1);
         tvperfume = findViewById(R.id.textperfume);
         wish2 = findViewById(R.id.wish2);
         tvkit = findViewById(R.id.textkit);
         wish3 = findViewById(R.id.wish3);
        tvsoap.setVisibility(View.GONE);
        wish1.setVisibility(View.GONE);
        tvperfume.setVisibility(View.GONE);
        wish2.setVisibility(View.GONE);
        tvkit.setVisibility(View.GONE);
        wish3.setVisibility(View.GONE);
         soap = findViewById(R.id.soap);


        soap.setOnClickListener(v -> {
            if(tvsoap.getVisibility() == View.GONE){
               tvsoap.setVisibility(View.VISIBLE);
               wish1.setVisibility(View.VISIBLE);
            }else if (tvsoap.getVisibility() == View.VISIBLE){
                tvsoap.setVisibility(View.GONE);
                wish1.setVisibility(View.GONE);
            }
        });
         perf = findViewById(R.id.perf);
        perf.setOnClickListener(v -> {
            if(tvperfume.getVisibility() == View.GONE){
                tvperfume.setVisibility(View.VISIBLE);
                wish2.setVisibility(View.VISIBLE);
            }else if (tvperfume.getVisibility() == View.VISIBLE){
                tvperfume.setVisibility(View.GONE);
                wish2.setVisibility(View.GONE);
            }
        });
         kit = findViewById(R.id.kit);
        kit.setOnClickListener(v -> {
            if (tvkit.getVisibility() == View.GONE) {
                tvkit.setVisibility(View.VISIBLE);
                wish3.setVisibility(View.VISIBLE);
            } else if (tvkit.getVisibility() == View.VISIBLE) {
                tvkit.setVisibility(View.GONE);
                wish3.setVisibility(View.GONE);
            }
        });

        wish1.setOnClickListener(v -> {

        getReference.child("Admin").child(userId).child("Order_Shop").push()
                .setValue(new Data_Order(nama[0],jenis,harga[0]))
                .addOnSuccessListener(Shop.this, aVoid -> Toast.makeText(Shop.this, "Berhasil Ditambahkan", Toast.LENGTH_SHORT).show());
        });

        wish2.setOnClickListener(v -> {
            getReference.child("Admin").child(userId).child("Order_Shop").push()
                    .setValue(new Data_Order(nama[1],jenis,harga[1]))
                    .addOnSuccessListener(Shop.this, aVoid -> Toast.makeText(Shop.this, "Berhasil Ditambahkan", Toast.LENGTH_SHORT).show());
        });

        wish3.setOnClickListener(v -> {
            getReference.child("Admin").child(userId).child("Order_Shop").push()
                    .setValue(new Data_Order(nama[2],jenis,harga[2]))
                    .addOnSuccessListener(Shop.this, aVoid -> Toast.makeText(Shop.this, "Berhasil Ditambahkan", Toast.LENGTH_SHORT).show());
        });
    }
}
