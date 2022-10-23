package com.example.pizza4u;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {

    TextView textview;
    EditText userName, password;
    Button signIn;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().hide();




        userName=(EditText)findViewById(R.id.editUserName);
        password=(EditText)findViewById(R.id.editPassword);
        signIn=(Button)findViewById(R.id.btnSignIn);

        myDB = new DBHelper(this);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = userName.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("admin99") && pass.equals("14940")) {
                    Toast.makeText(SignInActivity.this, "Admin login successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), AdminHome.class);
                    startActivity(intent);
                } else
                    {

                    if (user.equals("") || pass.equals("")) {
                        Toast.makeText(SignInActivity.this, "Please enter the Credentials", Toast.LENGTH_SHORT).show();
                    } else {
                        Boolean result = myDB.checkusernamepassword(user, pass);
                        if (result == true) {
                            Intent intent = new Intent(getApplicationContext(), DashBoard.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(SignInActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                        }


                    }
                }
            }
        });


        textview = (TextView) findViewById(R.id.textViewCreateAccount);
        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUpActivity();
            }
        });
    }



    public void SignUpActivity() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
}










