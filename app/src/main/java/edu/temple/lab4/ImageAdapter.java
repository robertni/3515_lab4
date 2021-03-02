package edu.temple.lab4;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter implements SpinnerAdapter {

    Context context;
    ArrayList<String> items;
    int[] images;
    String instructions = "Please select a dog";

    // constructor
    public ImageAdapter(Context context, ArrayList items, int[] images) {
        this.context = context;
        this.items = items;
        this.images = images;
    }

    // check if an item is a title
    private boolean isTitle(int position) {
        return position == 0;
    }

    @Override
    public int getCount() {
        return items.size() + 1;
    }

    @Override
    public Object getItem(int position) {
        if (isTitle(position)) {
            return null;
        } else {
            return items.get(position - 1);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;

        // create centered TextView when dropdown menu not open
        if ((textView = (TextView)convertView) == null) {
            textView = new TextView(context);
            textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            textView.setGravity(Gravity.CENTER_HORIZONTAL);
            textView.setTextSize(22);
        }

        // if first position - show instructions
        if (isTitle(position)) {
            textView.setText(instructions);
        } else {
            textView.setText(items.get(position - 1));
        }

        return textView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        // return title if position == 0
        if (isTitle(position)) {
            return getView(position, null, parent);
        }

        LinearLayout linearLayout;
        TextView textView;
        ImageView imageView;

        if (convertView instanceof TextView || convertView == null) {
            linearLayout = new LinearLayout(context);
            textView = new TextView(context);
            imageView = new ImageView(context);

            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            linearLayout.addView(imageView);
            linearLayout.addView(textView);

            imageView.getLayoutParams().height = 150;
            imageView.getLayoutParams().width = 150;

            textView.setPadding(10,15,15,15);
            textView.setTextSize(22);

        } else {
            linearLayout = (LinearLayout)convertView;
            imageView = (ImageView)linearLayout.getChildAt(0);
            textView = (TextView)linearLayout.getChildAt(1);
        }

        // position will always include 0 (title) - so look at one item prior
        imageView.setImageResource(images[position - 1]);
        textView.setText(items.get(position - 1));

        return linearLayout;
    }
}
