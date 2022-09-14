package com.spacecodee.app.sesion01.ejercicio.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.spacecodee.app.sesion01.ejercicio.R;
import com.spacecodee.app.sesion01.ejercicio.utils.Utils;

public class SignUpActivity extends AppCompatActivity {

    private EditText txtUsername;
    private EditText txtPassword;
    private EditText txtName;
    private EditText txtLastname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.txtUsername = this.findViewById(R.id.txtUsername);
        this.txtPassword = this.findViewById(R.id.txtPassword);
        this.txtName = this.findViewById(R.id.txtName);
        this.txtLastname = this.findViewById(R.id.txtLastname);
    }

    public void signUp(View view) {
        String username = this.txtUsername.getText().toString();
        String password = this.txtPassword.getText().toString();
        String name = this.txtName.getText().toString();
        String lastname = this.txtLastname.getText().toString();
        if (Utils.validateEmpty(username, password, name, lastname)) {
            Toast.makeText(this, "Debe ingresar todos los datos", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.putExtra("user", username);
            intent.putExtra("password", password);
            intent.putExtra("name", name);
            intent.putExtra("lastname", lastname);
            this.startActivity(intent);
        }
    }
}