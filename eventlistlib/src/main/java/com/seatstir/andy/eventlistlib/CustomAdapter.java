package com.seatstir.andy.eventlistlib;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by fred on 8/15/2015.
 */


class CustomAdapter extends ArrayAdapter<EventData> {

    Context context;

    public CustomAdapter(Context context, int resourceId,
                         List<EventData> items) {
        super(context, resourceId, items);
        this.context = context;
    }

    /*private view holder class*/
    private class ViewHolder {
        ImageView imageView;
        TextView txtEvent;
        TextView txtVenue;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        EventData eventData = getItem(position);
        LayoutInflater fasInflater = LayoutInflater.from(getContext());
        View customView = fasInflater.inflate(R.layout.custom_event, parent, false);


        TextView fasText = (TextView) customView.findViewById(R.id.textView2);
        ImageView fasImage = (ImageView) customView.findViewById(R.id.imageView);

        fasText.setText(eventData.getShortdesc());
        fasImage.setImageResource(R.drawable.beth);

        return customView;

    }
}
