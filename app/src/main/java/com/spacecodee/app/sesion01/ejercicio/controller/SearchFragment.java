package com.spacecodee.app.sesion01.ejercicio.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.spacecodee.app.sesion01.ejercicio.R;
import org.jetbrains.annotations.NotNull;

public class SearchFragment extends Fragment {

    private ImageView imgVJocker;
    private Switch swClick;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override public void onViewCreated(@NonNull @NotNull View view,
                                        @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.imgVJocker = this.requireView().requireViewById(R.id.imgVJocker);
        this.swClick = this.requireView().requireViewById(R.id.swClick);

        this.showJocker();
    }

    //active switch to show jocker
    private void showJocker() {
        this.imgVJocker.setVisibility(View.INVISIBLE);

        this.swClick.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                this.imgVJocker.setVisibility(View.VISIBLE);
            }
            else {
                this.imgVJocker.setVisibility(View.INVISIBLE);
            }
        });
    }
}