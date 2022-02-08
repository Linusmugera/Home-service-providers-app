package com.masterandroid.ehome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private EditText regusername;
    private EditText regemail;
    private EditText regpassword;
    private EditText regconfirmpass;
    private Button btnsignup;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        regusername = findViewById(R.id.regusername);
        regemail = findViewById(R.id.regemail);
        regpassword = findViewById(R.id.regpassword);
        regconfirmpass = findViewById(R.id.regconfirmpass);
        btnsignup = findViewById(R.id.btnsignup);

        auth = FirebaseAuth.getInstance();

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_username = regusername.getText().toString();
                String txt_email = regemail.getText().toString();
                String txt_password = regpassword.getText().toString();
                String txt_confirmpass = regconfirmpass.getText().toString();


                if (TextUtils.isEmpty(txt_username) || TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)
                || TextUtils.isEmpty(txt_confirmpass)){
                    Toast.makeText(RegisterActivity.this, "Empty Credentials", Toast.LENGTH_SHORT).show();
                } else if (txt_password.length() < 6){
                    Toast.makeText(RegisterActivity.this, "Password too short", Toast.LENGTH_SHORT).show();
                } else {
                    registerUser(txt_username , txt_email , txt_password , txt_confirmpass);
                }
            }
        });
    }

    private void registerUser(String username, String email, String password, String confirmpass) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(RegisterActivity.this, "Registering user successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this , StartActivity.class));
                    Toast.makeText(RegisterActivity.this, "Login to use the App", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(RegisterActivity.this,"User not registered", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}