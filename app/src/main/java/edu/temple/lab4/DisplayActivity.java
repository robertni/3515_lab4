package edu.temple.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {

    private final String title = "Display";

    ArrayList<String> dogArray;
    int[] dogImages;
    int position;

    ImageView displayImage;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        // set title of activity
        setTitle(title);

        // retrieve views from second layout
        displayImage = findViewById(R.id.displayImage);
        textView = findViewById(R.id.textView);

        // get data from intent
        Intent intent = getIntent();

        // get ArrayList<String> from intent
        dogArray = (ArrayList<String>)intent.getSerializableExtra("dogArray");

        // get images from intent
        dogImages = intent.getIntArrayExtra("dogImages");

        // get position from intent
        position = intent.getIntExtra("position", 0);

        // display the data in view
        displayImage.setImageResource(dogImages[position]);
        textView.setText(dogArray.get(position));
        textView.setGravity(Gravity.CENTER_HORIZONTAL);
    }
}
