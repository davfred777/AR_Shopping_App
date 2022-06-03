package com.example.ar_shopping_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout inputEmail, inputPassword, inputConfirmPassword;
    Button btnRegister;
    TextView alreadyHaveAccount;
    FirebaseAuth mAuth;
    ProgressDialog mLoadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        inputConfirmPassword = findViewById(R.id.inputConfirmPassword);
        btnRegister = findViewById(R.id.btnLogin);
        alreadyHaveAccount = findViewById(R.id.alreadyHaveAccount);
        mAuth = FirebaseAuth.getInstance();
        mLoadingBar = new ProgressDialog(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AttemptRegistration();
            }
        });

        alreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void AttemptRegistration()
    {
      String email = inputEmail.getEditText().getText().toString();
      String password = inputPassword.getEditText().getText().toString();
      String confirmPassword = inputConfirmPassword.getEditText().getText().toString();

      if(email.isEmpty() || !email.contains("@gmail"))
      {
          showError(inputEmail, "Email is not valid");
      } else if (password.isEmpty() || password.length()<5)
      {
          showError(inputPassword,"Password must be greater than 5 letters");
      }else if (!confirmPassword.equals(password))
      {
          showError(inputConfirmPassword,"Password did not Match");
      }
      else
      {
          mLoadingBar.setTitle("Registration");
          mLoadingBar.setMessage("Please Wait, While your credentials");
          mLoadingBar.setCanceledOnTouchOutside(false);
          mLoadingBar.show();
          mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
              @Override
              public void onComplete(@NonNull Task<AuthResult> task) {
                  if (task.isSuccessful())
                  {
                      mLoadingBar.dismiss();
                      Toast.makeText(RegisterActivity.this, "Registration is Succesfull", Toast.LENGTH_SHORT).show();
                      Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                      intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                      startActivity(intent);
                      finish();
                  }
                  else
                  {
                      mLoadingBar.dismiss();
                      Toast.makeText(RegisterActivity.this, "Registration has Failed ", Toast.LENGTH_SHORT).show();
                  }
              }
          });
      }
    }

    private void showError(TextInputLayout field, String text) {
        field.setError(text);
        field.requestFocus();
    }
}