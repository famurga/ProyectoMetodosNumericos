package com.example.proyectometodosnumericos.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.proyectometodosnumericos.R;
import com.example.proyectometodosnumericos.metodos.Lagrange;

public class CalculadoraFragment extends Fragment {

    TextView textX1,textX2,textX3,textX4;
    EditText editText1,editText2,editText3,editText4
            ,editTexty1,editTexty2,editTexty3,editTexty4, editTextValor, editTextResultado;
    Button btnCalcular;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_calculadora, container, false);


        editText1=v.findViewById(R.id.editX1);
        editText2=v.findViewById(R.id.editX2);
        editText3=v.findViewById(R.id.editX3);
        editText4=v.findViewById(R.id.editX4);
        editTexty1=v.findViewById(R.id.editY1);
        editTexty2=v.findViewById(R.id.editY2);
        editTexty3=v.findViewById(R.id.editY3);
        editTexty4=v.findViewById(R.id.editY4);
        editTextValor=v.findViewById(R.id.editValor);
        editTextResultado=v.findViewById(R.id.editResultado);

         //editText4.setFocusable(true);
        //editText4.setEnabled(false);
        btnCalcular=v.findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                double x1=Double.parseDouble(editText1.getText().toString());
                double x2=Double.parseDouble(editText2.getText().toString());
                double x3=Double.parseDouble(editText3.getText().toString());
                double x4=Double.parseDouble(editText4.getText().toString());
                double y1=Double.parseDouble(editTexty1.getText().toString());
                double y2=Double.parseDouble(editTexty2.getText().toString());
                double y3=Double.parseDouble(editTexty3.getText().toString());
                double y4=Double.parseDouble(editTexty4.getText().toString());
                double valorInter=Double.parseDouble(editTextValor.getText().toString());

                double arregloX[] =new double[4];
                double arregloY[] =new double[4];

                arregloX[0]=x1;
                arregloX[1]=x2;
                arregloX[2]=x3;
                arregloX[3]=x4;
                arregloY[0]=y1;
                arregloY[1]=y2;
                arregloY[2]=y3;
                arregloY[3]=y4;

                Lagrange l1= new Lagrange(arregloY,arregloX);
                double res=l1.getResultadoP(valorInter);


                String Res=""+res;
                editTextResultado.setText(Res);
            }
        });
        return v;
    }
}