package com.example.ntobekozwane.myapplication321;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int qntty = 0;
    //CheckBox whippdCream = findViewById(R.id.chkbx_whippedCream);
    boolean hasWhippedCream = false;
    boolean hasChocolate = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void SubmitOrder(View view)//calaculates order price/total...takes quantity * 5
    {
        CheckBox whippdCream = findViewById(R.id.chkbx_whippedCream);
        hasWhippedCream= whippdCream.isChecked();

        CheckBox chocolate = findViewById(R.id.chkbx_chocolate);
        hasChocolate= chocolate.isChecked();

        DisplayPrice(qntty *5);
    }
    private void Display(int number)//displays number of ordered items..increses or decreases
    {
        TextView qntity= findViewById(R.id.txtQuantity);
        qntity.setText(number);//should put the ""+ or else it wont run
    }
    private void DisplayPrice(int num)//displays total price
    {
        TextView txtOrderSummary= findViewById(R.id.txt_OrderSummary);
        txtOrderSummary.setText(createOrderSummary());

        //Log.v("MainActivity", "Has WhippedCream " + hasWhippedCream);

    }
    public void Increase(View view)
    {
        qntty = qntty + 1;
        Display(qntty);
    }
    public void Decrease(View view)
    {
        qntty = qntty - 1;
        Display(qntty);
    }
    public int calculatePrice()
    {
        return qntty * 5;
    }
    public String createOrderSummary()
    {
        //orderPrice=SubmitOrder();
        return "Name: Ntobeko Zwane"
                + "\nQuantity: "+qntty
                + "\nHas WhippedCream: " +hasWhippedCream
                + "\nHas Chocolate: " +hasChocolate

                + "\nTotal: "+calculatePrice()
                + "\nThank You";
    }
}
