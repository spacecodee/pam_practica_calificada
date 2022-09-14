package com.spacecodee.app.sesion01.ejercicio.controller;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.spacecodee.app.sesion01.ejercicio.R;
import com.spacecodee.app.sesion01.ejercicio.dto.UserDto;
import org.jetbrains.annotations.NotNull;

public class HomeFragment extends Fragment {

    private static final String[] COMBO_ITEMS = {"Multiplicar", "Dividir", "Restar", "Sumar"};
    private Spinner cbxActions;
    private EditText txtNumber1;
    private EditText txtNumber2;
    private Button btnCalc;
    private TextView lblWelcome;

    UserDto userDto;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override public void onViewCreated(@NonNull @NotNull View view,
                                        @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.cbxActions = this.requireView().requireViewById(R.id.cbxActions);
        this.txtNumber1 = this.requireView().findViewById(R.id.txtNumber1);
        this.txtNumber2 = this.requireView().findViewById(R.id.txtNumber2);
        this.btnCalc = this.requireView().findViewById(R.id.btnCalc);
        this.lblWelcome = this.requireView().findViewById(R.id.lblWelcome);

        this.userDto = ((MainActivity) this.requireActivity()).getUserDto();

        this.setWelcome();
        this.setComboItems();
        this.setListenerCombo();
        this.calcularAction();
    }

    private void setComboItems() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this.getContext(),
                                                               android.R.layout.simple_spinner_item,
                                                               HomeFragment.COMBO_ITEMS);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.cbxActions.setAdapter(arrayAdapter);
    }

    private void setListenerCombo() {
        this.cbxActions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO document why this method is empty
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                Toast.makeText(HomeFragment.this.getContext(), "Selecciona la acción", Toast.LENGTH_SHORT)
                     .show();
            }
        });
    }

    public void calcularAction() {
        this.btnCalc.setOnClickListener(v -> {
            String number1 = this.txtNumber1.getText().toString();
            String number2 = this.txtNumber2.getText().toString();
            String action = this.cbxActions.getSelectedItem().toString();
            String result;
            if (number1.trim().isEmpty() || number2.trim().isEmpty()) {
                Toast.makeText(this.getContext(), "Ingresa los números", Toast.LENGTH_SHORT).show();
            }
            else {
                double num1 = Double.parseDouble(number1);
                double num2 = Double.parseDouble(number2);

                switch (action) {
                    case "Dividir":
                        result = this.roundTotal(num1 / num2);
                        break;
                    case "Restar":
                        result = this.roundTotal(num1 - num2);
                        break;
                    case "Sumar":
                        result = this.roundTotal(num1 + num2);
                        break;
                    default:
                        result = this.roundTotal(num1 * num2);
                        break;
                }
                Toast.makeText(this.getContext(), result, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String roundTotal(double total) {
        return String.valueOf(Math.round(total * 100.0) / 100.0);
    }

    @SuppressLint("SetTextI18n")
    private void setWelcome() {
        this.lblWelcome.setText("Bienvenido " + this.userDto.getName() + " " + this.userDto.getLastName());
    }
}