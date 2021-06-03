package org.upm.btb.availablesensors;


import android.app.Activity;
import android.hardware.Sensor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class SensorListBaseAdapter extends BaseAdapter {

    private Activity context;
    private List<Sensor> availableSensorsList = null;

    public SensorListBaseAdapter(Activity context, List<Sensor> sensorList) {
        this.context = context;
        this.availableSensorsList = sensorList;
    }

    public static class ViewHolder
    {
        TextView textViewId;
        TextView textViewDesc;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        LayoutInflater inflater = context.getLayoutInflater();
        ViewHolder vh;
        if(convertView == null) {
            vh = new ViewHolder();
            row = inflater.inflate(R.layout.row_item, null, true);
            vh.textViewId = (TextView) row.findViewById(R.id.textViewId);
            vh.textViewDesc = (TextView) row.findViewById(R.id.textViewDesc);
            row.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        vh.textViewId.setText(availableSensorsList.get(position).getName());
        vh.textViewDesc.setText(availableSensorsList.get(position).getVendor());

        return row;
    }


    @Override
    public int getCount() {
        if (availableSensorsList!=null) return availableSensorsList.size();
        return 0;
    }

    @Override
    public Sensor getItem(int i) {
        Sensor sensor = null;
        if (availableSensorsList!=null) sensor = availableSensorsList.get(i);
        return sensor;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

}
