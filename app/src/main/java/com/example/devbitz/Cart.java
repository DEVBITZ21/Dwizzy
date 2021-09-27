package com.example.devbitz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.devbitz.Common.Common;
import com.example.devbitz.Model.Order;
import com.example.devbitz.Model.Request;
import com.example.devbitz.ViewHolder.CartAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import Database.Database;
import info.hoang8f.widget.FButton;

public class Cart extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference request;

    TextView txtTotalPrice;
    FButton btnPlace;
    List<Order> cart = new ArrayList<>();
    CartAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_cart );

        //firebase
        database = FirebaseDatabase.getInstance();
        request = database.getReference("Requests");

        //init
        recyclerView = (RecyclerView)findViewById( R.id.listCart );
        recyclerView.setHasFixedSize( true );
        layoutManager = new LinearLayoutManager( this );
        recyclerView.setLayoutManager( layoutManager );

        txtTotalPrice = (TextView)findViewById( R.id.total );
        btnPlace = (FButton)findViewById( R.id.btnPlaceOrder );

        loadListFood();
    }
    private void loadListFood(){
        cart = new Database( this ).getCarts();
        adapter = new CartAdapter( cart,this );
        recyclerView.setAdapter( adapter );

        //calculate total price
        int total = 0;
        for (Order order:cart)
            total+=(Integer.parseInt( order.getPrice() ))*(Integer.parseInt( order.getQuantity() ));
        Locale locale = new Locale( "en", "US" );
        NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);

        txtTotalPrice.setText( fmt.format( total ) );
        btnPlace=(FButton) findViewById( R.id.btnPlaceOrder );

        btnPlace.setOnClicklistner( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create req
                Request request = new Request(
                        Common.currentUser.getPhone(),
                        Common.currentUser.getName(),
                        address,
                        txtTotalPrice.getText().toString(),
                        cart
                )
            }
        } );
        loadListFood();
    }
}