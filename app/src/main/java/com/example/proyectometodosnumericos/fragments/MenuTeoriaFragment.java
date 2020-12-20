package com.example.proyectometodosnumericos.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.proyectometodosnumericos.R;

public class MenuTeoriaFragment extends Fragment {
    Button btnMinimoC ,btnLineal,btnPolinomial;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_menu_teoria, container, false);

        btnMinimoC=root.findViewById(R.id.btnAjusteTeoria);
        btnLineal=root.findViewById(R.id.btnTeoInterLineal);
        btnPolinomial=root.findViewById(R.id.btnTeoriaPolinomial);

        btnMinimoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_nav_gallery_to_teoriaMinimosFragment);

            }
        });

        btnPolinomial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_nav_gallery_to_teoriaInterpolacionFragment);
            }
        });


        return root;
    }




}