package edu.temple.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

public class SelectionActivity extends AppCompatActivity {

    private final String title = "Item Selection";
    Spinner spinner;
    ImageView imageView;
    int[] dogImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set title of the activity
        setTitle(title);

        // retrieve views from xml
        spinner = findViewById(R.id.spinner);
        imageView = findViewById(R.id.imageView);

        // create ArrayList of dogs
        ArrayList dogArray = new ArrayList<String>();
        dogArray.add("Happy Dog");
        dogArray.add("Masked Dog");
        dogArray.add("Many Dogs");
        dogArray.add("Doge");

        dogImages = new int[]{R.drawable.dog1, R.drawable.dog2, R.drawable.dog3, R.drawable.dog4};

        // create custom adapter
        ImageAdapter adapter = new ImageAdapter(this, dogArray, dogImages);
        spinner.setAdapter(adapter); // attach custom adapter to spinner

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    //showPicture(position - 1);

                    // declare new intent
                    Intent intent = new Intent(SelectionActivity.this, DisplayActivity.class);

                    // pass data to intent
                    intent.putExtra("dogArray", dogArray);
                    intent.putExtra("dogImages", dogImages);
                    intent.putExtra("position", position - 1);

                    // start the activity
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void showPicture(int position) {
        imageView.setImageResource(dogImages[position]);
    }
}