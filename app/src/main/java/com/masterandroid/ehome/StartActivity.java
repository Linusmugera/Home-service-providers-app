package com.masterandroid.ehome;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class StartActivity extends AppCompatActivity {

    private Button crtaccount;
    private Button btnlogin;
    private EditText email;
    private EditText password;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        crtaccount = findViewById(R.id.crtaccount);
        btnlogin = findViewById(R.id.btnLogin);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        auth = FirebaseAuth.getInstance();

        crtaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartActivity.this, RegisterActivity.class));
                finish();
            }
        });


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_email = email.getText().toString();
                String txt_password = password.getText().toString();

                if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)) {
                    Toast.makeText(StartActivity.this, "Empty Credentials", Toast.LENGTH_SHORT).show();
                } else if(email.getText().toString().equals("linus") && password.getText().toString().equals("123456")) {
                    Toast.makeText(StartActivity.this, "Admin Login Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(StartActivity.this, AdminActivity.class));

                }

                    else{
                    loginUser(txt_email, txt_password);
                }

            }
        });

    }

    private void loginUser(String email, String password) {
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(StartActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(StartActivity.this, WelcomeActivity.class));
                finish();
            }
        });
    }


}