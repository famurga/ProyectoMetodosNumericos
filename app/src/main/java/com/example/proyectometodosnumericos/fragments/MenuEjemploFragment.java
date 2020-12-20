package com.example.proyectometodosnumericos.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.proyectometodosnumericos.R;
import com.example.proyectometodosnumericos.ui.slideshow.SlideshowViewModel;

public class MenuEjemploFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;

    private Button btnMinimos,btnLineal,btnLagrange,btnNewton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_menu_ejemplos, container, false);

        btnMinimos=root.findViewById(R.id.btnEjercicioMinimos);
        btnLineal=root.findViewById(R.id.btnEjerciciosInterLineal);
        btnLagrange=root.findViewById(R.id.btnEjercicioLagrange);
        btnNewton=root.findViewById(R.id.btnEjercicioNewton);

        btnMinimos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_nav_slideshow_to_ejemploMinimosFragment);

            }
        });

        btnLineal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_nav_slideshow_to_ejemploInterpolacionLinealFragment);


            }
        });
        btnLagrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_nav_slideshow_to_ejemploLagrangeFragment);


            }
        });
        btnNewton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return root;
    }
}