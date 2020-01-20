package com.example.schedulista.ui.login;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schedulista.R;
import com.example.schedulista.Registration;
import com.example.schedulista.activity_gender;

public class LoginActivity extends AppCompatActivity {

    private Button button;
    private LoginViewModel loginViewModel;
    Button login;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button = findViewById(R.id.register);
        button.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(LoginActivity.this, Registration.class);
                        startActivity(intent);
                    }
                }
        );


        login = findViewById(R.id.login);
        login.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(LoginActivity.this, activity_gender.class);
                        startActivity(intent);
                    }
                }
        );


    }
}
