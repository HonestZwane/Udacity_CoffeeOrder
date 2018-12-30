package com.example.ntobekozwane.myapplication321;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int qntty = 0;
    //CheckBox whippdCream = findViewById(R.id.chkbx_whippedCream);
    boolean hasWhippedCream = false;
    boolean hasChocolate ;//= false;
    String userName = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void SubmitOrder(View view)//calaculates order price/total...takes quantity * 5
    {
        EditText name = findViewById(R.id.edt_name);
        userName=name.getText().toString();

        CheckBox whippdCream = findViewById(R.id.chkbx_whippedCream);
        hasWhippedCream= whippdCream.isChecked();

        CheckBox chocolate = findViewById(R.id.chkbx_chocolate);
        hasChocolate= chocolate.isChecked();

        /*Intent intent =new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee Order for " + userName);
        intent.putExtra(Intent.EXTRA_TEXT, createOrderSummary());
        if(intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);*/


        DisplayPrice(qntty *5);
    }

    private void Display(int number)//displays number of ordered items..increses or decreases
    {
        TextView qntity= findViewById(R.id.txtQuantity);
        qntity.setText(""+number);//should put the ""+ or else it wont run
    }
    private void DisplayPrice(int num)//displays total price
    {
        TextView txtOrderSummary= findViewById(R.id.txt_OrderSummary);
        txtOrderSummary.setText(createOrderSummary());

        //Log.v("MainActivity", "Has WhippedCream " + hasWhippedCream);
    }
    public void Increase(View view)
    {
        if(qntty<100)
            qntty = qntty + 1;

        else
             Toast.makeText(this, "cant order more than 100 cups", Toast.LENGTH_SHORT).show();

            Display(qntty);
    }
    public void Decrease(View view)
    {
        if(qntty>0)
            qntty = qntty - 1;

        else
            Toast.makeText(this, "cant order negative cups", Toast.LENGTH_SHORT).show();

        Display(qntty);
    }
    public int calculatePrice()
    {
        int basicprice=5;
        if(hasChocolate)
            basicprice=basicprice+1;

        if(hasWhippedCream)
            basicprice=basicprice+2;
        //sum = qntty*5;

        return basicprice * qntty;
    }
    public String createOrderSummary()
    {
        //orderPrice=SubmitOrder();
        return "Name: "+userName
                + "\nQuantity: "+qntty
                + "\nHas WhippedCream: " +hasWhippedCream
                + "\nHas Chocolate: " +hasChocolate

                + "\nTotal: "+calculatePrice()
                + "\nThank You";
    }

    public void SendEmail(View view)
    {
        Intent intent =new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee Order for " + userName);
        intent.putExtra(Intent.EXTRA_TEXT, createOrderSummary());
        if(intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);

    }
}
