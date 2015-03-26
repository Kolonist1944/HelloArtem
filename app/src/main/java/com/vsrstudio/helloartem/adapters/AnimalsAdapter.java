package com.vsrstudio.helloartem.adapters;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.vsrstudio.helloartem.R;

public class AnimalsAdapter extends BaseAdapter {

    private final Context context;
    private final String[] animalNames;
    private final int[] animalPics;

    public AnimalsAdapter(final Context context, final String[] animalNames, final int[] animalPics) {
        this.context = context;
        this.animalNames = animalNames;
        this.animalPics = animalPics;
    }

    private static class ViewHolder {
        TextView animalName;
        RoundedImageView image;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null || convertView.getTag() == null) {
            convertView = View.inflate(context, R.layout.animals_list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.animalName = (TextView) convertView.findViewById(R.id.animal_name);
            viewHolder.image = (RoundedImageView) convertView.findViewById(R.id.animal_pic);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.animalName.setText(animalNames[position]);

        viewHolder.image.setOval(true);
        viewHolder.image.setBorderColor(context.getResources().getColor(R.color.black));
        viewHolder.image.setBorderWidth(1f);
        viewHolder.image.setImageResource(animalPics[position]);

        return convertView;
    }

    @Override
    public int getCount() {
        return animalNames.length;
    }

    @Override
    public Object getItem(int position) {
        return animalNames[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
