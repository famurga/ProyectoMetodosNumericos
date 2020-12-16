package com.example.proyectometodosnumericos.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectometodosnumericos.R;
import com.example.proyectometodosnumericos.metodos.InterpolacionLineal;
import com.example.proyectometodosnumericos.metodos.Lagrange;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class InterpolacionLinealFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private EditText x0,x1,x,y0,y1,y;
    private Double x0Var,x1Var,xVar,y0Var,y1Var,yVar;
    private Button BotonCalcular, BotonGraficar;
    private TextView txtResult;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_interpolacion_lineal, container, false);

        x0=root.findViewById(R.id.txtdatoX0);
        y0=root.findViewById(R.id.txtdatoY0);
        x1=root.findViewById(R.id.txtdatoX1);
        y1=root.findViewById(R.id.txtdatoY1);
        y=root.findViewById(R.id.txtdatoY);
        BotonCalcular=root.findViewById(R.id.btnCalcularInterpolacionLineal);
        BotonGraficar=root.findViewById(R.id.btnGraficar);
        BotonCalcular.setOnClickListener(this);
        BotonGraficar.setOnClickListener(this);
        txtResult=root.findViewById(R.id.txtResul);

        x0Var = Double.parseDouble(x0.getText().toString());
        y0Var = Double.parseDouble(y0.getText().toString());
        x1Var = Double.parseDouble(x1.getText().toString());
        y1Var = Double.parseDouble(y1.getText().toString());
        xVar = Double.parseDouble(x.getText().toString());
        y0Var = Double.parseDouble(y.getText().toString());


        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

             case R.id.btnCalcularLagrange:
                InterpolacionLineal I1= new InterpolacionLineal(x0Var,x1Var,y0Var,y1Var,xVar,yVar);
                double res=I1.valor();
                // editInterpo.getText().clear();
                String Res=""+res;
                txtResult.setText(Res);
                break;
        }
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
