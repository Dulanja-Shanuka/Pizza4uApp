package com.example.pizza4u;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    TextView textview;
    EditText username, password, repassword;
    Button signUp;
    DBHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();


        textview = (TextView) findViewById(R.id.textViewSignIn);

        username = (EditText) findViewById(R.id.editUserName);
        password = (EditText) findViewById(R.id.editPassword);
        repassword = (EditText) findViewById(R.id.editComfirmPassword);
        signUp = (Button) findViewById(R.id.buttonRegister);
        myDB = new DBHelper(this);


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if (user.equals("") || pass.equals("") || repass.equals("")) {
                    Toast.makeText(SignUpActivity.this, "Fill all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (pass.equals(repass)) {
                        Boolean usercheckResult = myDB.checkusername(user);
                        if (usercheckResult == false) {
                            Boolean regResult = myDB.insertData(user, pass);
                            if (regResult == true) {
                                Toast.makeText(SignUpActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),SignInActivity.class);
                                startActivity(intent );
                            } else {
                                Toast.makeText(SignUpActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(SignUpActivity.this, "User Already Exists.\n     Please Sign In", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(SignUpActivity.this, "Password not Matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),SignInActivity.class);
                startActivity(intent);
            }
        });
    }
}















