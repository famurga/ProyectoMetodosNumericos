package com.example.proyectometodosnumericos.fragments;

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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.proyectometodosnumericos.R;
import com.example.proyectometodosnumericos.metodos.Lagrange;
import com.example.proyectometodosnumericos.metodos.MinimosCuadrados;

import java.util.ArrayList;

public class CalculadoraMinimosFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener{
    private EditText t1,t2,editInterpo;
    private Button b1, BotonCalcular,BotonGraficar;
    private TextView txtResult;
    ListView mlistView,mlistView2;
    private ArrayList<Double> mLista= new ArrayList<>();
    private ArrayAdapter<Double> mAdapter;
    private ArrayList<Double> mLista2= new ArrayList<>();
    private ArrayAdapter<Double>mAdapter2;
    GraficarFragment fragment;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_calculadora_minimos, container, false);
        t1=root.findViewById(R.id.txtdatoX);
        t2=root.findViewById(R.id.txtdatoY);
        editInterpo=root.findViewById(R.id.editValorAinterpolar);
        b1=root.findViewById(R.id.botonAñadir);
        BotonCalcular=root.findViewById(R.id.btnCalcularMinimos);
        BotonGraficar=root.findViewById(R.id.btnGraficar);
        b1.setOnClickListener(this);
        BotonCalcular.setOnClickListener(this);
        BotonGraficar.setOnClickListener(this);
        mlistView=root.findViewById(R.id.listView);
        mlistView.setOnItemClickListener(this);
        mlistView2=root.findViewById(R.id.listView2);
        mlistView2.setOnItemClickListener(this);
        txtResult=root.findViewById(R.id.txtResul);
        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.botonAñadir:
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

            case R.id.btnCalcularMinimos:

                int longitud1=mLista.size();
                double[] ArregloX1=new double[longitud1];
                double[] ArregloY1=new double[longitud1];
                for(int i=0;i<longitud1;i++){
                    ArregloX1[i]=mLista.get(i);
                    ArregloY1[i]=mLista2.get(i);
                }
                //double x[]={2,3,5,7,9};
               // double y[]={4,5,7,10,15};


                MinimosCuadrados mc=new MinimosCuadrados(ArregloX1,ArregloY1);
                String Res = mc.resultado();
                String Error = mc.calcularR();
                //System.out.println(mc.calcularR());
                //System.out.print(mc.resultado());
                //Lagrange l1= new Lagrange(mLista2,mLista);
                //double valorInter=Double.parseDouble(editInterpo.getText().toString());
                //double res=l1.getResultadoPArrayList(valorInter);
                // editInterpo.getText().clear();
                //String Res=""+res;
                txtResult.setText("Funcion: \n"+Res+"\nCoeficiente de determinacion: "+Error);
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
