package com.example.proyectometodosnumericos.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.proyectometodosnumericos.R;
import com.example.proyectometodosnumericos.metodos.Lagrange;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class GraficarFragment extends Fragment {

private LineGraphSeries<DataPoint> series;
private GraphView funcion;
private double X,Y;
    private ArrayList<Double> ArrayListX=new ArrayList<>();
    private ArrayList<Double> ArrayListy= new ArrayList<>();
    double []ax;
    double []ay;
    int longiA;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*

        getParentFragmentManager().setFragmentResultListener("key", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {

                ax=result.getDoubleArray("arrayx");
                Log.e("Pruebita2","El tamaño del Arreglo X que llega  es"+ax.length);
                Log.e("Pruebita3","El elemento 1 del Arreglo X que llega  es"+ax[0]);

                ay=result.getDoubleArray("arrayy");


                for (int i=0;i<ax.length;i++){
                    ArrayListX.add(ax[i]);
                    Log.e("Pruebita4","El elemento del Arreglo X que se asigna es"+ArrayListX.get(i));
                    ArrayListy.add(ay[i]);
                }
                Log.e("Pruebita5","El elemento del Arreglo X que se asigna es"+ArrayListX);

            }

        });

 */

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_graficar, container, false);
        // Inflate the layout for this fragment
       // X=-50;

        //Bundle datosRecuperados = getArguments();
        if(getArguments()!=null) {


                   longiA=getArguments().getInt("idlong");
            //  ax=new double[longiA];
            // ay=new double[longiA];
            ax = getArguments().getDoubleArray("idx");
            ay = getArguments().getDoubleArray("idy");
            Log.e("Pruebita8","El elemento tamño del arreglo recibido  es"+ax.length);
            for (int i=0;i<ax.length;i++){
                ArrayListX.add(ax[i]);
                Log.e("Pruebita4","El elemento del Arreglo X que se asigna es"+ArrayListX.get(i));
                ArrayListy.add(ay[i]);
            }
        }


        Log.e("Pruebita6","El elemento del Arreglo X que se asigna es"+ArrayListX);
        funcion = v.findViewById(R.id.grapViewFunction);
        funcion.getViewport().setScrollable(true);
        funcion.getViewport().setScrollableY(true);
        funcion.getViewport().setScalable(true);
        funcion.getViewport().setScalableY(true);
        funcion.getViewport().setXAxisBoundsManual(true);
        funcion.getViewport().setMinX(-10);
        funcion.getViewport().setMaxX(10);


        series = new LineGraphSeries<DataPoint>();
        for(int i=0;i<500;i++){
            X+=0.1;
            Lagrange l1= new Lagrange(ArrayListy,ArrayListX);
             Log.e("Pruebita1","El Arreglo X es"+ArrayListX);
            double res=l1.getResultadoPArrayList(X);
            Y=res;
            series.appendData(new DataPoint(X,Y),true,500);
             Log.e("Pruebita","El dato es"+Y);

        }
        funcion.addSeries(series);
        return v;
    }
}