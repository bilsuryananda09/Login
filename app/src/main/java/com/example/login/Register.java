package com.example.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrasi_layout);

        final EditText username = (EditText) findViewById(R.id.rgsUser);
        final EditText email = (EditText) findViewById(R.id.rgsEmail);
        final EditText password = (EditText) findViewById(R.id.rgsPass);
        Button btnRegister = (Button) findViewById(R.id.btnRegis);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
                String newUser = username.getText().toString();
                String newEmail = email.getText().toString();
                String newPass = password.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();

                editor.putString(newUser + newPass + "data", newUser +"\n"+ newEmail);
                editor.commit();

                Intent loginScreen = new Intent(Register.this, MainActivity.class);
                startActivity(loginScreen);
            }
        });

    }
}
