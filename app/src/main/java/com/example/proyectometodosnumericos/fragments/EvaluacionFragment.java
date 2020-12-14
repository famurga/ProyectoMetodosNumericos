package com.example.proyectometodosnumericos.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;

import com.example.proyectometodosnumericos.R;
import com.example.proyectometodosnumericos.TableDynamic;

import java.util.ArrayList;


public class EvaluacionFragment extends Fragment {

    TableLayout tableLayout;
    EditText editTextX1,editTextY1;
    Button btnAña;
    String[]header={"ID","X","Y"};
    private ArrayList<String[]> rows= new ArrayList<>();
    private TableDynamic tableDynamic;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v= inflater.inflate(R.layout.fragment_evaluacion, container, false);

        tableLayout=v.findViewById(R.id.table);
        editTextX1=v.findViewById(R.id.edtX1);
        editTextY1=v.findViewById(R.id.edty1);
        btnAña= v.findViewById(R.id.btnAñadir);


         tableDynamic= new TableDynamic(tableLayout,getContext());
        tableDynamic.addHeader(header);
        tableDynamic.addData(getClientes());
        tableDynamic.backGroundHeader(Color.BLUE);
        tableDynamic.backgroundData(Color.RED,Color.YELLOW);

        btnAña.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String[] item= new String[]{"id",editTextX1.getText().toString(),editTextY1.getText().toString()};
                tableDynamic.addItems(item);

                Log.e("Prueba","Datos"+rows.get(1)[2]);

            }
        });


        return v;
    }

    private ArrayList<String[]> getClientes(){

        rows.add(new String[]{"1","15","0"});
        rows.add(new String[]{"2","16","0"});
        rows.add(new String[]{"3","17","0"});
        rows.add(new String[]{"4","18","0"});

        return rows;
    }

}