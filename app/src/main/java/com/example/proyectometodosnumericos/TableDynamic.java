package com.example.proyectometodosnumericos;

import android.content.Context;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TableDynamic {
    private TableLayout tableLayout;
    private Context context;
    String[] header;
    ArrayList<String[]>data;
    private TableRow tableRow;
    private TextView textCell;
    private int indexC;
    private int indexR;
    private boolean multicolor= false;
    int firstColor, secondColor;


    public TableDynamic(TableLayout tableLayout, Context context) {
        this.tableLayout=tableLayout;
        this.context=context;
    }

    public void addHeader(String[] header){
        this.header=header;
        createHeader();

    }
    public void addData(ArrayList<String[]>data){
        this.data=data;
        createDateTable();

    }

    private void newRow(){
        tableRow= new TableRow(context);
    }
    private void newCell(){
        textCell= new TextView(context);
        textCell.setGravity(Gravity.CENTER);
        textCell.setTextSize(25);
    }

    private void createHeader(){
        indexC=0;
        newRow();
        while (indexC<header.length){
            newCell();
            textCell.setText(header[indexC++]);
            tableRow.addView(textCell,newTableRowParams());
        }
        tableLayout.addView(tableRow);
    }

    private void createDateTable() {

        String info;
        for (indexR = 1; indexR <= header.length; indexR++) {
            newRow();
            for (indexC = 0; indexC <= header.length; indexC++) {
                    newCell();
                    String []row=data.get(indexR-1);
                    info=(indexC<row.length)?row[indexC]:"";
                    textCell.setText(info);
                    tableRow.addView(textCell,newTableRowParams());
            }
            tableLayout.addView(tableRow);
        }
    }


    public void addItems(String [] item){
        String info;
        data.add(item);
        indexC=0;
        newRow();
        while(indexC<header.length){
            newCell();
            info=(indexC<item.length)?item[indexC++]:"";
            textCell.setText(info);
            tableRow.addView(textCell,newTableRowParams());
        }
        tableLayout.addView(tableRow,data.size()-1);

        reColoring();
    }

    public void backGroundHeader(int color){


        indexC=0;
        newRow();
        while (indexC<header.length){
            textCell=getCell(0,indexC++);
            textCell.setBackgroundColor(color);
        }


    }

    public void backgroundData(int firstColor, int secondColor){
        for (indexR = 1; indexR <= header.length; indexR++) {
            multicolor=!multicolor;
            for (indexC = 0; indexC <= header.length; indexC++) {
                textCell=getCell(indexR,indexC);
                textCell.setBackgroundColor((multicolor)?firstColor:secondColor);
            }

        }
        this.firstColor=firstColor;
        this.secondColor=secondColor;

    }

    public void reColoring(){
        indexC=0;
        multicolor=!multicolor;
        while (indexC<header.length){
            textCell=getCell(data.size()-1,indexC++);
            textCell.setBackgroundColor((multicolor)?firstColor:secondColor);
        }


    }



    private TableRow getRow(int index){
        return (TableRow)tableLayout.getChildAt( index);
    }
    private TextView getCell(int rowIndex,int columIndex){
        tableRow=getRow(rowIndex);
        return (TextView) tableRow.getChildAt(columIndex);
    }
    private  TableRow.LayoutParams newTableRowParams(){
             TableRow.LayoutParams params = new TableRow.LayoutParams();
             params.setMargins(1,1,1,1);
             params.weight=1;
             return params;
    }
}
