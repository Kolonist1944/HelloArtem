package com.vsrstudio.helloartem.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vsrstudio.helloartem.R;

public class CountriesAdapter extends BaseAdapter {

    private final Context context;
    private final String[] countriesList;

    public CountriesAdapter(final Context context, final String[] array) {
        this.context = context;
        this.countriesList = array;
    }

    private static class ViewHolder {
        TextView countryName;
        ImageView image;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null || convertView.getTag() == null) {
            convertView = View.inflate(context, R.layout.countries_list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.countryName = (TextView) convertView.findViewById(R.id.country_name);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.countryName.setText(countriesList[position]);

        int randomNumber = (int) (Math.random() * 3);
        switch (randomNumber) {
            case 0:
                viewHolder.image.setImageResource(R.mipmap.ic_3d);
                break;
            case 1:
                viewHolder.image.setImageResource(R.mipmap.ic_action_circle);
                break;
            case 2:
                viewHolder.image.setImageResource(R.mipmap.ic_launcher);
                break;
        }

        return convertView;
    }

    @Override
    public int getCount() {
        return countriesList.length;
    }

    @Override
    public Object getItem(int position) {
        return countriesList[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
