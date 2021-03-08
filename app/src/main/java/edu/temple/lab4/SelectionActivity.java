package edu.temple.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class SelectionActivity extends AppCompatActivity {

    private final String title = "Item Selection";
    private final String instructions = "Please select a dog";

    TextView instructionText;
    GridView gridView;
    int[] dogImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set title of the activity
        setTitle(title);

        // retrieve views from xml
        instructionText = findViewById(R.id.instructionText);
        gridView = findViewById(R.id.gridView);

        // change instruction text
        instructionText.setText(instructions);

        // create ArrayList of dogs
        ArrayList dogArray = new ArrayList<String>();
        dogArray.add("Happy Dog");
        dogArray.add("Masked Dog");
        dogArray.add("Many Dogs");
        dogArray.add("Doge");

        dogImages = new int[]{R.drawable.dog1, R.drawable.dog2, R.drawable.dog3, R.drawable.dog4};

        // create custom adapter
        ImageAdapter adapter = new ImageAdapter(this, dogArray, dogImages);
    }

    private void showPicture(int position) {
        //imageView.setImageResource(dogImages[position]);
    }
}