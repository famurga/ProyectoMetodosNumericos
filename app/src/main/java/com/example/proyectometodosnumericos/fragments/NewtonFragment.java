package com.example.proyectometodosnumericos.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectometodosnumericos.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.proyectometodosnumericos.R;
import com.example.proyectometodosnumericos.metodos.InterpolacionNewton;
import com.example.proyectometodosnumericos.metodos.Lagrange;
import com.example.proyectometodosnumericos.ui.gallery.GalleryViewModel;

import java.util.ArrayList;
import java.util.List;

import static com.example.proyectometodosnumericos.metodos.InterpolacionNewton.solucionar;

public class NewtonFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private EditText t1,t2,editInterpo, edtCantidadD;
    private Button b1, BotonCalcular,BotonGraficar;
    private TextView txtResult,txtValor1,txtValor2,txtValor3,txtValor4;
    ListView mlistView,mlistView2;
    private ArrayList<Double> mLista= new ArrayList<>();
    private ArrayAdapter<Double>mAdapter;
    private ArrayList<Double> mLista2= new ArrayList<>();
    private ArrayAdapter<Double>mAdapter2;

    private int cantidad, contador=0;
    private String valorDif="";

    private double[] x;
    private double[] y;
    private double[] b;

    GraficarFragment fragment;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_newton, container, false);

        t1=root.findViewById(R.id.txtdatox);
        t2=root.findViewById(R.id.txtdatoY);
        editInterpo=root.findViewById(R.id.editValorAinterpolar);
        b1=root.findViewById(R.id.botonAñadir);
        BotonCalcular=root.findViewById(R.id.btnCalcularNewton);
        BotonGraficar=root.findViewById(R.id.btnGraficar);
        b1.setOnClickListener(this);
        BotonCalcular.setOnClickListener(this);
        BotonGraficar.setOnClickListener(this);
        mlistView=root.findViewById(R.id.listView);
        mlistView.setOnItemClickListener(this);
        mlistView2=root.findViewById(R.id.listView2);
        mlistView2.setOnItemClickListener(this);
        txtResult=root.findViewById(R.id.txtResul);
        edtCantidadD=root.findViewById(R.id.editCantidadDatos);

        txtValor1=root.findViewById(R.id.txtvalor1);
        txtValor2=root.findViewById(R.id.txtvalor2);
        txtValor3=root.findViewById(R.id.txtvalor3);
        txtValor4=root.findViewById(R.id.txtvalor4);


        return root;
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.botonAñadir:
                cantidad= (int)Integer.parseInt(edtCantidadD.getText().toString().trim());
                x=new double[cantidad];
                y=new double[cantidad];

                Double text=Double.parseDouble(t1.getText().toString().trim());
                mLista.add(text);


                t1.getText().clear();
                mAdapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,mLista);
                mlistView.setAdapter(mAdapter);

                Double text2=Double.parseDouble(t2.getText().toString().trim());
                mLista2.add(text2);


                t2.getText().clear();
                mAdapter2 = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,mLista2);
                mlistView2.setAdapter(mAdapter2);

                break;

            case R.id.btnCalcularNewton:

                for(int k=0;k<cantidad;k++){
                    x[k]=mLista.get(k);
                    y[k]=mLista2.get(k);
                }

                InterpolacionNewton interpolacionNewton=new InterpolacionNewton();

                for (int j=0;j<cantidad;j++){

                    Log.e("Valor del arreglo X","es"+x[j]);
                    Log.e("Valor del arreglo Y","es"+y[j]);
                }


                b=solucionar(x,y);


                for (int i = 0; i < b.length; i++) {
                    System.out.println(b[i]);

                }


                txtValor1.setText(""+b[0]);
                txtValor2.setText(""+b[1]);
                if(b.length>2){
                    txtValor3.setText(""+b[2]);
                }
                 if(b.length>4){
                txtValor4.setText(""+b[0]);
            }



                double valorInter=Double.parseDouble(editInterpo.getText().toString());
                double res=interpolacionNewton.calcularValor(valorInter,b,x);
                // editInterpo.getText().clear();
                String Res=""+res;
                txtResult.setText(Res);
                break;


            case R.id.btnGraficar:

                int longitud=mLista.size();
                double[] ArregloX=new double[longitud];
                double[] ArregloY=new double[longitud];

                for(int i=0;i<longitud;i++){
                    ArregloX[i]=mLista.get(i);
                    ArregloY[i]=mLista2.get(i);
                }


                Bundle datos=new Bundle();
                datos.putInt("idlong",longitud);
                datos.putDoubleArray("idx",ArregloX);
                datos.putDoubleArray("idy",ArregloY);
                fragment=new GraficarFragment();
                fragment.setArguments(datos);
                FragmentManager fragmentManager =  getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment,fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


/*
                Bundle bundle=new Bundle();
                bundle.putDoubleArray("arrayx",ArregloX);
                bundle.putDoubleArray("arrayy",ArregloY);
                getParentFragmentManager().setFragmentResult("key",bundle);


 */

                // Navigation.findNavController(v).navigate(R.id.action_lagrange1Fragment_to_GraficarFragment);


        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getContext(), "Item clicked"+position, Toast.LENGTH_SHORT).show();

    }
}

