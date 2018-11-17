package com.example.ntobekozwane.myapplication321;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int qntty = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void SubmitOrder(View view)
    {
        DisplayPrice(qntty *5);
    }
    private void Display(int number)
    {
        TextView qntty= findViewById(R.id.txtQuantity);
        qntty.setText(number);
    }
    private void DisplayPrice(int num)
    {
        TextView txtprice= findViewById(R.id.txtPrice);
        String txt = qntty + " cups cost R" + num;
        txtprice.setText(txt);
        //txtprice.setText("Total " + NumberFormat.getCurrencyInstance().format(num));
    }
    public void Increase(View view)
    {
        //int qntty = 3;
        qntty = qntty + 1;
        Display(qntty);
    }
    public void Decrease(View view)
    {
        //int qntty = 3;
        qntty = qntty - 1;
        Display(qntty);
    }
}
