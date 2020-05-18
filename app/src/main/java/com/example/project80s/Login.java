package com.example.project80s;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText email,pass;
    TextView t2;
    ProgressBar pb;
    private FirebaseAuth mAuth;
    Button l ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setStatusBarColor(Color.BLACK);
        email = findViewById(R.id.nama);
        pass = findViewById(R.id.password);
        t2 = findViewById(R.id.register);
        pb = findViewById(R.id.progressBar);
        pb.setVisibility(View.GONE);
        mAuth = FirebaseAuth.getInstance();
        l = findViewById(R.id.button2);
        t2.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), Register.class);
            startActivity(intent);
        });

       l.setOnClickListener(v -> {
           if(TextUtils.isEmpty(email.getText())){
               email.setError("Harus Diisi");
           }else if (TextUtils.isEmpty(pass.getText())){
               pass.setError("Harus Diisi");
           }else {
               pb.setVisibility(View.VISIBLE);
               mAuth.signInWithEmailAndPassword(email.getText().toString(), pass.getText().toString()).addOnCompleteListener(task -> {
                   pb.setVisibility(View.GONE);
                   if(task.isSuccessful()){
                       showDialog();
                   }else{
                       Toast.makeText(Login.this,task.getException().getMessage(), Toast.LENGTH_LONG).show();
                   }
               });
           }
       });
    }

    private void showDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);
        alertDialogBuilder.setTitle("Sukses?");
        alertDialogBuilder
                .setMessage("Klik Ya untuk lanjutkan!")
                .setCancelable(false)
                .setPositiveButton("Ya", (dialog, id) -> {
                    Intent i=new Intent(Login.this,Homepage.class);
                    startActivity(i);
                })
                .setNegativeButton("Tidak", (dialog, id) -> dialog.cancel());
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}
