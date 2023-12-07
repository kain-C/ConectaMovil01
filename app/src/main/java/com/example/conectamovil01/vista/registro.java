package com.example.conectamovil01.vista;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.conectamovil01.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class registro extends AppCompatActivity {

    EditText username, email,password;
    Button Registrar;
    FirebaseAuth auth;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        username = findViewById(R.id.txt_nombre);
        email = findViewById(R.id.txt_email);
        password = findViewById(R.id.txt_password);
        Registrar = findViewById(R.id.btnRegistrer);
        auth = FirebaseAuth.getInstance();

        Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtusername = username.getText().toString();
                String txtemail = email.getText().toString();
                String txtpassword = password.getText().toString();

                if (TextUtils.isEmpty(txtusername) || TextUtils.isEmpty(txtemail) || TextUtils.isEmpty(txtpassword)){
                    Toast.makeText(registro.this, "faltan campos requeridos", Toast.LENGTH_SHORT).show();
                }else if(txtpassword.length() < 6){
                    Toast.makeText(registro.this, "la contraseña es muy corta", Toast.LENGTH_SHORT).show();
                } else{
                   register(txtusername,txtemail,txtpassword);
                }

            }
        });
    }
    private void register(final String username, String email, String password){
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    FirebaseUser firebaseUser = auth.getCurrentUser();
                    assert firebaseUser != null;
                    String userid = firebaseUser.getUid();
                    reference = FirebaseDatabase.getInstance().getReference("Users").child(userid);
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("id",userid);
                    hashMap.put("username",username);
                    hashMap.put("imageURL", "default");

                    reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Intent intent = new Intent(registro.this, Principal.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                finish();
                            }
                        }
                    });
                }else{
                    Toast.makeText(registro.this, "error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}