package com.example.proyectometodosnumericos.fragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectometodosnumericos.R;


public class PantallaPrincipalFragment extends Fragment implements View.OnClickListener {

    FragmentTransaction transaction;
    Fragment FragmentTeoria, FragmentSoporte,FragmentCalculadora,
            FragmentEjemplos, FragmentAcercadeNosotros;

    CardView cardViewActividades,cardviewTareas,cardviewMiperfil,cardviewinformacion,
            cardviewEjemplo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pantalla_principal, container, false);





        cardViewActividades = v.findViewById(R.id.ActicardId);
        cardviewTareas = v.findViewById(R.id.TaskCardId);
        cardviewMiperfil = v.findViewById(R.id.PerfilCardId);
        cardviewinformacion = v.findViewById(R.id.AcercaCardId);
        cardviewEjemplo = v.findViewById(R.id.EjemplosCardId);

        cardViewActividades.setOnClickListener((View.OnClickListener) this);
        cardviewTareas.setOnClickListener((View.OnClickListener) this);
        cardviewMiperfil.setOnClickListener((View.OnClickListener) this);
        cardviewinformacion.setOnClickListener((View.OnClickListener) this);
        cardviewEjemplo.setOnClickListener((View.OnClickListener) this);

        FragmentCalculadora = new CalculadoraFragment();
        FragmentTeoria = new MenuTeoriaFragment();
        FragmentSoporte = new SoporteFragment();
        FragmentEjemplos = new EjemploFragment();
        //FragmentEjemplos = new SlideshowFragment();
        return v;

    }


    public void onClick(View v) {
        transaction = getFragmentManager().beginTransaction();

        switch (v.getId()){

            case R.id.ActicardId:
                Navigation.findNavController(v).navigate(R.id.action_PantallaInicio_to_nav_gallery);
                break;
            case R.id.TaskCardId:
                transaction.replace(R.id.nav_host_fragment,FragmentEjemplos);
                transaction.addToBackStack(null);
                break;
            case R.id.PerfilCardId:
                Navigation.findNavController(v).navigate(R.id.action_PantallaInicio_to_calculadora);
               /* transaction.replace(R.id.nav_host_fragment,FragmentCalculadora);
                transaction.addToBackStack(null);

                */
                break;
            case R.id.AcercaCardId:
                transaction.replace(R.id.nav_host_fragment,FragmentSoporte);
                transaction.addToBackStack(null);
                break;

        }
        transaction.commit();

    }
}