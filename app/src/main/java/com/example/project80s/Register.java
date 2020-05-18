package com.example.project80s;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    EditText nl,un,pw,ph;
    CheckBox acc;
    FirebaseAuth firebaseAuth;
    ProgressBar pb2;
    Button r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getWindow().setStatusBarColor(Color.BLACK);
        firebaseAuth = firebaseAuth.getInstance();
        FirebaseApp.initializeApp(this);
         nl = findViewById(R.id.nama);
         un = findViewById(R.id.username);
         pw = findViewById(R.id.password);
         ph = findViewById(R.id.phone);
         acc = findViewById(R.id.checkBox2);
         pb2 = findViewById(R.id.progg);
        pb2.setVisibility(View.GONE);
         r = findViewById(R.id.button);
        r.setOnClickListener(v -> {
            pb2.setVisibility(View.VISIBLE);
            if(TextUtils.isEmpty(nl.getText())){
                nl.setError("Harus Diisi");
            }else if(TextUtils.isEmpty(un.getText())){
                un.setError("Harus Diisi");
            }else if(TextUtils.isEmpty(pw.getText())){
                pw.setError("Harus Diisi");
            }else if(TextUtils.isEmpty(ph.getText())){
                ph.setError("Harus Diisi");
            }else if(acc.isChecked() == false){
                acc.setError("Centang Dahulu");
            }else{
            firebaseAuth.createUserWithEmailAndPassword(nl.getText().toString(), pw.getText().toString()).addOnCompleteListener(task -> {
                pb2.setVisibility(View.GONE);
                if(task.isSuccessful()) {
                    Toast.makeText(Register.this, "Registered successfully", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Register.this, Login.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(Register.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            });
            }
        });
    }

    public void showDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);
        alertDialogBuilder.setTitle("Registrasi Berhasil?");
        alertDialogBuilder
                .setMessage("Klik Ya untuk kembali ke login!")
                .setIcon(R.mipmap.ic_launcher)
                .setCancelable(false)
                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        Intent i=new Intent(Register.this,Login.class);
                        startActivity(i);
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
