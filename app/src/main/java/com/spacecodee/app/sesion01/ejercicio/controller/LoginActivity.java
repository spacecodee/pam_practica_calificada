package com.spacecodee.app.sesion01.ejercicio.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.spacecodee.app.sesion01.ejercicio.R;
import com.spacecodee.app.sesion01.ejercicio.dto.UserDto;
import com.spacecodee.app.sesion01.ejercicio.utils.Utils;

public class LoginActivity extends AppCompatActivity {

    private EditText txtUser;
    private EditText txtPassword;
    private UserDto userDto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.txtUser = this.findViewById(R.id.txtUsername);
        this.txtPassword = this.findViewById(R.id.txtPassword);
        this.userDto = Utils.getUserDto(this.getIntent().getExtras());
        //
    }

    public void login(View view) {
        String user = this.txtUser.getText().toString().trim();
        String password = this.txtPassword.getText().toString().trim();
        if (user.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Debe ingresar usuario y contraseña", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(this, MainActivity.class);
            if (this.userDto != null) {
                System.out.println("this.userDto = " + this.userDto);
                this.setExtras(intent, this.userDto.getUser(), this.userDto.getPassword(), this.userDto.getName(),
                               this.userDto.getLastName());
            }
            else {
                this.setExtras(intent, user, password, "Un Nombre", "Apellido xd");
            }

            this.startActivity(intent);
        }
    }

    public void goToSignUp(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        this.startActivity(intent);
    }

    private void setExtras(Intent intent, String... extras) {
        if (extras != null) {
            intent.putExtra("user", extras[0]);
            intent.putExtra("password", extras[1]);
            intent.putExtra("name", extras[2]);
            intent.putExtra("lastname", extras[3]);
        }
    }
}