package com.example.violencedetection;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class SignupActivity extends AppCompatActivity {
    private EditText nameEdit, emailEdit, phoneEdit, passwordEdit;
    private Button signupButton;
    private TextView loginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        nameEdit = findViewById(R.id.et_nameSignup);
        emailEdit = findViewById(R.id.et_emailSignup);
        phoneEdit = findViewById(R.id.et_phoneSignup);
        passwordEdit = findViewById(R.id.et_passwordSignup);
        signupButton = findViewById(R.id.btn_signup);
        loginLink = findViewById(R.id.tv_loginLink);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEdit.getText().toString();
                String email = emailEdit.getText().toString();
                String phone = phoneEdit.getText().toString();
                String password = passwordEdit.getText().toString();

                if (validateInput(name, email, phone, password)) {
                    // Perform signup logic here
                    Toast.makeText(SignupActivity.this, "Signup Successful!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private boolean validateInput(String name, String email, String phone, String password) {
        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Add phone number validation
        if (!android.util.Patterns.PHONE.matcher(phone).matches()) {
            Toast.makeText(this, "Please enter a valid phone number", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}

