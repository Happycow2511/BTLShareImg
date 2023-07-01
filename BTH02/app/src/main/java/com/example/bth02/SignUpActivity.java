package com.example.bth02;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    EditText edt1,edt2,edt3;
    private Button btnLogin,btnSignup,btn3;

    UserList userList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiti_sign_up);
        btnLogin=(Button)findViewById(R.id.btnLogin);
        btnSignup=(Button)findViewById(R.id.btnSignup);
        btn3 = (Button)findViewById(R.id.button3);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1 = (EditText) findViewById(R.id.editText);
                edt2 = (EditText) findViewById(R.id.editText2);
                edt3 = (EditText) findViewById(R.id.editText3);
                String email, pw, pw2;
                email = edt1.getText().toString();
                pw = edt2.getText().toString();
                pw2 = edt3.getText().toString();
                if (pw.equals(pw2)) {
                    Users user = new Users(email, pw);
                    if (user.checkValidPassword()&&user.checkValidEmail()){
                        userList.addUser(user);
                        Toast toast = Toast.makeText(SignUpActivity.this, "User created", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else {
                        Toast toast = Toast.makeText(SignUpActivity.this, "Invalid information", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
                else {
                    Toast toast = Toast.makeText(SignUpActivity.this, "Password does not match", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

    }
}