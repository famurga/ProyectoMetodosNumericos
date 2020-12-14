package com.example.proyectometodosnumericos.metodos;

import java.util.ArrayList;

public class Lagrange {
    ArrayList<Double>y1;
    ArrayList<Double>x1;
    ArrayList<Double>a1;
    private double y[];
    private double x[];
    private double a[];

    public Lagrange(double y[], double x[]) {
        this.x = x;
        this.y = y;
        a=new double[x.length];
    }
    public Lagrange( ArrayList<Double>y1,  ArrayList<Double>x1) {
        this.x1=x1;
        this.y1=y1;
       a1=new ArrayList<Double>();
    }

    private void getPolinomios_a() {

        double mult;
        System.out.println("Los coeficientes ");

        for(int i=0;i<y.length;i++){
            mult = 1;

            for(int j=0;j<x.length;j++){

                if(i==j)continue;
                mult=(x[i]-x[j])*mult;
            }
            a[i]=y[i]/mult;

            System.out.print("a"+"["+i+"]="+a[i]+"  ");


        }
    }

    private void getPolinomios_aArrayList() {

        double mult;
        System.out.println("Los coeficientes ");

        for(int i=0;i<y1.size();i++){
            mult = 1;

            for(int j=0;j<x1.size();j++){

                if(i==j)continue;
                mult=(x1.get(i)-x1.get(j))*mult;
            }
            a1.add(y1.get(i)/mult);
            //a1.set(i,y1.get(i)/mult);

            //System.out.print("a"+"["+i+"]="+a[i]+"  ");
            System.out.print("a"+"["+i+"]="+a1.get(i)+"  ");

        }
    }

    public double getResultadoP(double p){
        getPolinomios_a();

        double mult=1;
        double valores[]=new double[a.length];
        System.out.println("");
        for(int i=0;i<a.length;i++){
            mult=1;
            for(int j=0;j<a.length;j++){

                if(i==j)continue;
                mult=(p-x[j])*mult;

            }
            valores[i]=a[i]*mult;
            System.out.print(valores[i]);
            if(i!=a.length-1)System.out.print(" + ");

        }

        double resultado=0;
        for(int k=0;k<valores.length;k++){

            resultado=resultado+valores[k];
        }

        return resultado;

    }


    public double getResultadoPArrayList(double p){
        getPolinomios_aArrayList();
        double mult=1;
        ArrayList<Double>valores1=new ArrayList<>();
        System.out.println("");
        for(int i=0;i<a1.size();i++){
            mult=1;
            for(int j=0;j<a1.size();j++){

                if(i==j)continue;
                mult=(p-x1.get(j))*mult;

            }
            //valores1.set(i,a1.get(i)*mult);
            valores1.add(a1.get(i)*mult);
            System.out.println(valores1.get(i));
            if(i!=a1.size()-1)System.out.print(" + ");

        }

        double resultado=0;
        for(int k=0;k<valores1.size();k++){

            resultado=resultado+valores1.get(k);
        }

        return resultado;

    }

}
