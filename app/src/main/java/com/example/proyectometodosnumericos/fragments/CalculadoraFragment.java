package com.example.proyectometodosnumericos.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.proyectometodosnumericos.R;
import com.example.proyectometodosnumericos.metodos.Lagrange;

public class CalculadoraFragment extends Fragment {

    Button btnLagrange, btnAjuste,btnLagrange1,btnNewton,btnLineal;

    FragmentTransaction transaction;
    Fragment fragmentLagrange, fragmentAjusteC;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_calculadora, container, false);

        btnLagrange= v.findViewById(R.id.btnLagrange);
        btnLagrange1= v.findViewById(R.id.btnLagrange1);
        btnNewton=v.findViewById(R.id.btnNewton);
        btnLineal=v.findViewById(R.id.btnInterLineal);
        btnAjuste=v.findViewById(R.id.btnAjuste);

        fragmentLagrange = new CalculadoraLagrangeFragment();
        fragmentAjusteC = new CalculadoraLagrangeFragment();

       // getActivity().getSupportFragmentManager().beginTransaction().add(R.id.drawer_layout,fragmentLagrange);

        btnLagrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Navigation.findNavController(v).navigate(R.id.action_calculadora_to_temasFragment);

           /* transaction=getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.nav_host_fragment,fragmentLagrange);
            transaction.addToBackStack(null);
            transaction.commit();

            */



            }
        });
        btnLagrange1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_calculadora_to_lagrange1Fragment);
            }
        });
        btnNewton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_calculadora_to_newtonFragment);

            }
        });

        btnLineal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_calculadora_to_interpolacionLinealFragment);

            }
        });
        btnAjuste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_calculadora_to_calculadoraMinimosFragment);

            }
        });


        return v;
    }
}