package com.kylelevydevgmail.brewwhiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView currentFlavor;
    AutoCompleteTextView desiredFlavor;
    private static final String[] FLAVORS = {"Aromatic","Astringent","Balanced","Beefy","Big","Bitter","Bland",
            "Bulky","Buttery","Creamy","Delicate","Dilute","Dry","Dull","Dusty","Empty","Faint","Flimsy","Fragile",
            "Fruity","Gentle","Harsh","Heavy","Hefty","Insipid","Intense","Limp","Luscious","Mouth-filling","Muted",
            "Nuanced","Nutty","Overwhelming","Pleasing","Plump","Potent","Powdery","QuickFinish","Rich","Robust","Salty",
            "Scrawny","Severe","Slender","Smooth","Soft","Soupy","Sour","Sparse","Sticky","Strong","Substantial","Sweet",
            "Tasty","Tea-like","Thick","Thin","Transparent","Underwhelming","Vegetal","Watery"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CoffeeCompass covfefe = new CoffeeCompass();


        currentFlavor = findViewById(R.id.currentFlavor);
        desiredFlavor = findViewById(R.id.desiredFlavor);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, FLAVORS);
        currentFlavor.setAdapter(adapter);
        desiredFlavor.setAdapter(adapter);
    }
}
