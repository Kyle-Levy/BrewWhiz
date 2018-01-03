package com.kylelevydevgmail.brewwhiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner currentFlavor;
    private Spinner desiredFlavor;
    private static final String[] FLAVORS = {"Aromatic","Astringent","Balanced","Beefy","Big","Bitter","Bland",
            "Bulky","Buttery","Creamy","Delicate","Dilute","Dry","Dull","Dusty","Empty","Faint","Flimsy","Fragile",
            "Fruity","Gentle","Harsh","Heavy","Hefty","Insipid","Intense","Limp","Luscious","Mouth-filling","Muted",
            "Nuanced","Nutty","Overwhelming","Pleasing","Plump","Potent","Powdery","QuickFinish","Rich","Robust","Salty",
            "Scrawny","Severe","Slender","Smooth","Soft","Soupy","Sour","Sparse","Sticky","Strong","Substantial","Sweet",
            "Tasty","Tea-like","Thick","Thin","Transparent","Underwhelming","Vegetal","Watery"};
    
    private String currentFlavorString;
    private String desiredFlavorString;
    private TextView extractText;
    private TextView coffeeText;
    private Button brewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CoffeeCompass covfefe = new CoffeeCompass();


        currentFlavor = findViewById(R.id.currentFlavor);
        desiredFlavor = findViewById(R.id.desiredFlavor);
        extractText = findViewById(R.id.extractText);
        coffeeText = findViewById(R.id.coffeeText);
        brewButton = findViewById(R.id.brewButton);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, FLAVORS);
        currentFlavor.setAdapter(adapter);
        desiredFlavor.setAdapter(adapter);

        currentFlavor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                currentFlavorString = (String) adapterView.getItemAtPosition(pos);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //currentFlavorString = null;
            }
        });

        desiredFlavor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                desiredFlavorString = (String) adapterView.getItemAtPosition(pos);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //desiredFlavorString = null;
            }
        });

        brewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float[] directions = covfefe.calculateBrewChanges(currentFlavorString, desiredFlavorString);

                extractText.setText("Coffee: " + directions[0] + "");
                coffeeText.setText("Extract: " + directions[1] + " and Z-Change: " + directions[2]);
            }
        });


    }
}
