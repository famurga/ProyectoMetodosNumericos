package com.example.proyectometodosnumericos.fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectometodosnumericos.R;

import java.util.ArrayList;

public class SoporteFragment extends Fragment {
    LinearLayout layout,contenedorBoton;
    TableLayout tabla;
    TableRow row;
    TextView textView;
     TextView X,Y;
     ArrayList<Double> datosX =new ArrayList<>();
    ArrayList<Double> datosY =new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View vi = inflater.inflate(R.layout.fragment_soporte, container, false);
/*
         X=(TextView)vi.findViewById(R.id.txtXX);
         Y=(TextView)vi.findViewById(R.id.txtYY);
        Button agregar=vi.findViewById(R.id.btnagregar1);
        tabla=vi.findViewById(R.id.table2);
        tabla.setGravity(Gravity.CENTER_HORIZONTAL);
        tabla.setPadding(20,20,20,20);
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Abrimos un vector donde se almacena los dos datos de entrada
                String [] cadena={X.getText().toString(),Y.getText().toString()};


                //abrimos el table row agregar las filas
                 row=new TableRow(getContext());
                for(int i=0;i<2;i++){
                    //abrimos un constructor del textview haciendo referencia a este proyecto
                    textView = new TextView(getContext());
                    //para centrar el texto
                    textView.setGravity(Gravity.CENTER_VERTICAL);
                    //le damos dimenciones al textview
                    textView.setPadding(15, 15, 15, 15);
                    textView.setTextSize(20);
                    //un color de fondo
                    textView.setBackgroundResource(R.color.colorPrimary);
                    //agregamos los datos del vector cadena uno por uno al textview
                    textView.setText(cadena[i]);
                    //color de texto en el textview
                    textView.setTextColor(Color.WHITE);
                    //agregamos el textview al TableRow
                    row.addView(textView);
                    datosX.add(Double.parseDouble(cadena[i]));

                }
                //Finalmente agregamos el TableRow al TableLayout
                tabla.addView(row);

                Log.e("DATOSSS","los datos de X son "+datosX);
                Log.e("DATOSSS","los datos de X son "+datosX.get(1));

            }

        });

*/

        return vi;


        /*
        layout = v.findViewById(R.id.layout);
        for (int i = 0; i < 8; i++) {
            contenedorBoton = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.fragment_soporte, null);
            ImageView btn = v.findViewById(R.id.boton);
            contenedorBoton.setTag(i);

            contenedorBoton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), " Listener botón " + v.getTag(), Toast.LENGTH_SHORT).show();
                }
            });

            layout.addView(contenedorBoton);

        }

         */

    }
}
