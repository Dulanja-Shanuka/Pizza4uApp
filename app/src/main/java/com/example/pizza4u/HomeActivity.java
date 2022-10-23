package com.example.pizza4u;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button button,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();


        button = (Button) findViewById(R.id.btnSignIn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignInActivity();
            }
        });

        button2=(Button) findViewById(R.id.btnSingUp);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUpActivity();
            }
        });
    }

    public void SignInActivity() {
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);

    }


    public void SignUpActivity(){
        Intent intent1=new Intent(this,SignUpActivity.class);
        startActivity(intent1);

    }
}