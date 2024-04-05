package com.example.bmicalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText edtWeight, edtHeightft, edtHeightin;
        TextView tvResult;
        Button button;
        LinearLayout llcolors;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightft = findViewById(R.id.edtHeightft);
        edtHeightin = findViewById(R.id.edtHeightin);
        tvResult = findViewById(R.id.tvResult);
        button = findViewById(R.id.button);
        llcolors = findViewById(R.id.llcolors);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             int wt =  Integer.parseInt(edtWeight.getText().toString());
             int ft =  Integer.parseInt(edtHeightft.getText().toString());
             int in =  Integer.parseInt(edtHeightin.getText().toString());

             int totalIn = ft*12+in;
             double totalCm = totalIn*2.53;
             double totalM = totalCm/100;
             double bmi = wt/(totalM*totalM);

             if(bmi>25){
                 tvResult.setText("You're Overweight!");
                 llcolors.setBackgroundColor(getResources().getColor(R.color.red));
             }else if (bmi<18){
                 tvResult.setText("You're Underweight!");
                 llcolors.setBackgroundColor(getResources().getColor(R.color.yello));
             }else {
                 tvResult.setText("You're Healthy");
                 llcolors.setBackgroundColor(getResources().getColor(R.color.green));
             }
            }
        });


    }
    @Override
    public void onBackPressed() {


        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setMessage("You want to exit?");
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                moveTaskToBack(true);
            }
        });
        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.show();
    }
}