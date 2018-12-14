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
    public void SubmitOrder(View view)//calaculates order price/total...takes quantity * 5
    {
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
        //String txt = qntty + " cups cost R" + num;//from part 1
        String txt2 = createOrderSummary();
        txtOrderSummary.setText(txt2);
        //txtprice.setText("Total " + NumberFormat.getCurrencyInstance().format(num));
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
                + "\nTotal: "+calculatePrice()
                + "\nThank You";
    }
}
