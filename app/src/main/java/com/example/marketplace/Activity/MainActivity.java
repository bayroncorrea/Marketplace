package com.example.marketplace.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.marketplace.Adapter.PopularAdapter;
import com.example.marketplace.Domain.PopularDomain;
import com.example.marketplace.R;
import com.example.marketplace.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        statusBarColor();
        initRecyclerVIew();
        bottomNavigation();
    }

    private void bottomNavigation() {
        binding.cartBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, CartActivity.class)));
    }

    private void statusBarColor() {
        Window window=MainActivity.this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.purple_Dark));
    }

    private void initRecyclerVIew(){
        ArrayList<PopularDomain> items = new ArrayList<>();

        items.add(new PopularDomain("t-shirt black","item_1",15,4,500,
                "El Apple Watch es un reloj inteligente diseñado y comercializado por Apple Inc.\n" +
                        "Es una extensión del iPhone y proporciona una variedad de funciones que incluyen:\n\n" +
                        "Modelos y tamaños:\n" +
                        "Viene en varios modelos y tamaños, generalmente en 40 mm y 44 mm.\n" +
                        "Disponible en aluminio, acero inoxidable y titanio.\n" +
                        "Pantalla Retina OLED, que ofrece colores vibrantes y alta resolución.\n\n" +
                        "Monitorización de la actividad:\n"+
                        "Registra pasos, calorías quemadas y distancia recorrida.\n\n" +
                        "Frecuencia cardíaca:\n"+
                        "Mide la frecuencia cardíaca y puede alertar sobre ritmos irregulares."));
        items.add(new PopularDomain("smart watch","item_2",10,4.5,450,"El Apple Watch es un reloj inteligente diseñado y comercializado por Apple Inc.\n" +
                        "Es una extensión del iPhone y proporciona una variedad de funciones que incluyen:\n\n" +
                        "Modelos y tamaños:\n" +
                        "Viene en varios modelos y tamaños, generalmente en 40 mm y 44 mm.\n" +
                        "Disponible en aluminio, acero inoxidable y titanio.\n" +
                        "Pantalla Retina OLED, que ofrece colores vibrantes y alta resolución.\n\n" +
                        "Monitorización de la actividad:\n"+
                        "Registra pasos, calorías quemadas y distancia recorrida.\n\n" +
                        "Frecuencia cardíaca:\n"+
                        "Mide la frecuencia cardíaca y puede alertar sobre ritmos irregulares."));
        items.add(new PopularDomain("phone","item_3",3,4.9,800,"El Apple Watch es un reloj inteligente diseñado y comercializado por Apple Inc.\n" +
                        "Es una extensión del iPhone y proporciona una variedad de funciones que incluyen:\n\n" +
                        "Modelos y tamaños:\n" +
                        "Viene en varios modelos y tamaños, generalmente en 40 mm y 44 mm.\n" +
                        "Disponible en aluminio, acero inoxidable y titanio.\n" +
                        "Pantalla Retina OLED, que ofrece colores vibrantes y alta resolución.\n\n" +
                        "Monitorización de la actividad:\n"+
                        "Registra pasos, calorías quemadas y distancia recorrida.\n\n" +
                        "Frecuencia cardíaca:\n"+
                        "Mide la frecuencia cardíaca y puede alertar sobre ritmos irregulares."));
        binding.PopularView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
        binding.PopularView.setAdapter(new PopularAdapter(items));
    }
}