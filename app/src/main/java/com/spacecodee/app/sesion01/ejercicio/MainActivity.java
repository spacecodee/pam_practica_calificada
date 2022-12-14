package com.spacecodee.app.sesion01.ejercicio;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.bottomNavigationView = findViewById(R.id.bottomNavigationView);
        this.fragmentReplace(new HomeFragment());
        this.bottomNViewItemListener();
    }

    @SuppressLint("NonConstantResourceId") private void bottomNViewItemListener() {
        this.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.settings:
                    this.fragmentReplace(new SettingsFragment());
                    break;
                case R.id.search:
                    this.fragmentReplace(new SearchFragment());
                    break;
                case R.id.user:
                    this.fragmentReplace(new UserFragment());
                    break;
                default:
                    this.fragmentReplace(new HomeFragment());
                    break;
            }
            return true;
        });
    }

    private void fragmentReplace(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}