package edu.temple.lab4;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> items;
    int[] images;

    // constructor
    public ImageAdapter(Context context, ArrayList items, int[] images) {
        this.context = context;
        this.items = items;
        this.images = images;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if ((view = (View) convertView) == null) {
            view = new View(context);

            view = inflater.inflate(R.layout.grid_layout, null);

            TextView text = view.findViewById(R.id.gridText);
            ImageView image = view.findViewById(R.id.gridImage);

            text.setText(items.get(position));
            image.setImageResource(images[position]);
        }

        return view;
    }
}
