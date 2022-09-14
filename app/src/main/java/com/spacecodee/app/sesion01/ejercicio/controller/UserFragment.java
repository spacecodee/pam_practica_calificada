package com.spacecodee.app.sesion01.ejercicio.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.spacecodee.app.sesion01.ejercicio.R;
import org.jetbrains.annotations.NotNull;

public class UserFragment extends Fragment {

    private ImageView imageView3;
    private SeekBar seekBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    @Override public void onViewCreated(@NonNull @NotNull View view,
                                        @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.seekBar = this.requireView().requireViewById(R.id.seekBar);
        this.imageView3 = this.requireView().requireViewById(R.id.imageView3);

        //get seekbar number
        this.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                UserFragment.this.imageView3.getLayoutParams().width = progress * 4;
                UserFragment.this.imageView3.requestLayout();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //get seekbar number
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //get seekbar number
            }
        });
    }
}