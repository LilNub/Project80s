package com.example.project80s;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getWindow().setStatusBarColor(Color.BLACK);
        final EditText nl = findViewById(R.id.nama);
        final EditText un = findViewById(R.id.username);
        final EditText pw = findViewById(R.id.password);
        final EditText ph = findViewById(R.id.phone);
        final CheckBox acc = findViewById(R.id.checkBox2);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                    showDialog();
                }
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
