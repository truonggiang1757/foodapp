package com.example.lbtg1.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.lbtg1.R;
import com.example.lbtg1.databinding.ActivitySignupBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;

public class SignupActivity extends BaseActivity {
    ActivitySignupBinding binding;
    private String TAG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setVariable();
    }

    private void setVariable() {
        binding.signupBtn.setOnClickListener(v -> {
            String email = binding.userEdt.getText().toString();
            String password = binding.passEdt.getText().toString();

            if(password.length()<6){
                Toast.makeText(SignupActivity.this, "Your password must be at least 6 character", Toast.LENGTH_SHORT).show();
                return;
            }
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignupActivity.this, (OnCompleteListener<AuthResult>) task -> {
                if(task.isSuccessful()){
                    Log.i(TAG, "onComplete: ");
                    startActivity(new Intent(SignupActivity.this, MainActivity.class));
                } else {
                    Log.i(TAG, "failure: " + task.getException());
                    Toast.makeText(SignupActivity.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}