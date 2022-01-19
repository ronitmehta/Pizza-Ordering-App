package com.example.pizzaorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    static String topping = "";
    static String summary = "";
    static String name = "";
    static int totalPizza = 0;
    static boolean tomato1 = false;
    static boolean corn1 = false;
    static boolean chesse1 = false;
    TextView order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent in = getIntent();
        name = name + in.getStringExtra("userName");
        TextView user =  findViewById(R.id.Name);
        user.setText(name);
        this.order = findViewById(R.id.count);
        this.order.setText(String.valueOf(totalPizza));

    }

    static int top = 0;
    public void nonVeg(View view) {
        Switch tomato =(Switch) findViewById(R.id.switch2);
        tomato1 = tomato.isChecked();
    }

    public void addTomatoes(){
        top = top + 20;
        if(topping.length()>0){
            topping = topping + "+ Tomatoes ";
        }
        else {
            topping = topping + "Tomatoes ";
        }
    }

    public void Veg(View view) {
        Switch corn = (Switch) findViewById(R.id.switch1);
        corn1 = corn.isChecked();
    }

    public void addCorn(){
        top = top + 20;
        if(topping.length()>0){
            topping = topping + "+ sweet corn ";
        }
        else {
            topping = topping + "sweet corn ";
        }
    }

    public void margheritta(View view) {
        Switch chesse = (Switch) findViewById(R.id.switch3);
        chesse1 = chesse.isChecked();
    }

    public void addChesse(){
        top = top + 50;
        if(topping.length()>0){
            topping = topping + "+ extra chesse ";
        }
        else {
            topping = topping + "extra chesse ";
        }
    }

    public void decrement(View view) {
        totalPizza = totalPizza - 1;
        this.order.setText(String.valueOf(totalPizza));
    }

    public void increment(View view) {
        totalPizza = totalPizza + 1;
        this.order.setText(String.valueOf(totalPizza));
    }

    public void placeOrder(View view) {
        if(tomato1){
            addTomatoes();
        }
        if(chesse1){
            addChesse();
        }
        if(corn1){
            addCorn();
        }
        int finalcost = top*totalPizza + totalPizza*180;
        summary = "Name " + name + " topping opted "+ topping+ " Total cost= Rs "+finalcost+ " Total number of pizza "+totalPizza;
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        String to = "kumarsunil98180@gmail.com";
        String[] rec = to.split(",");
        intent.putExtra(Intent.EXTRA_EMAIL, rec);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Order Summary");
        intent.putExtra(Intent.EXTRA_TEXT, summary);
        startActivity(Intent.createChooser(intent, "Choose an E-mail client"));
    }
}