package com.spacecodee.app.sesion01.ejercicio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import org.jetbrains.annotations.NotNull;

public class SettingsFragment extends Fragment {

    private EditText txtEmail;
    private Button btnSendEmail;

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override public void onViewCreated(@NonNull @NotNull View view,
                                        @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.txtEmail = this.requireView().requireViewById(R.id.txtEmail);
        this.btnSendEmail = this.requireView().requireViewById(R.id.btnSendEmail);

        this.sendEmail();
    }

    private boolean validateEmail() {
        String email = this.txtEmail.getText().toString().trim();
        if (email.isEmpty()) {
            this.txtEmail.setError("El campo no puede estar vacío");
            return false;
        }
        if (email.contains("@") && email.contains(".com")) {
            this.txtEmail.setError("El email no es válido");
            return true;
        }
        return true;
    }

    private void sendEmail() {
        this.btnSendEmail.setOnClickListener(v -> {
            if (this.validateEmail()) {
                Toast.makeText(this.getContext(), "Email enviado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}