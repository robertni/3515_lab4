package edu.temple.lab4;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    private final String title = "Display";

    TextView text;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        text = findViewById(R.id.textView);
        image = findViewById(R.id.displayImage);

        // set title of activity
        setTitle(title);

        // get data from intent
        Intent intent = getIntent();

        // display the data in view
        text.setText(intent.getStringExtra("name"));
        image.setImageResource(intent.getIntExtra("image", R.drawable.ic_launcher_foreground));
    }
}
