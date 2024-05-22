package es.upm.btb.availablesensors;

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

    public static class ViewHolder {
        TextView textViewId;
        TextView textViewDesc;
        TextView textViewType;
        TextView textViewMaxRange;
        TextView textViewResolution;
        TextView textViewPower;
        TextView textViewMinDelay;
        TextView textViewFifoReservedEventCount;
        TextView textViewFifoMaxEventCount;
        TextView textViewVersion;
        TextView textViewReportingMode;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        LayoutInflater inflater = context.getLayoutInflater();
        ViewHolder vh;
        if (convertView == null) {
            vh = new ViewHolder();
            row = inflater.inflate(R.layout.row_item, null, true);
            vh.textViewId = row.findViewById(R.id.textViewId);
            vh.textViewDesc = row.findViewById(R.id.textViewDesc);
            vh.textViewType = row.findViewById(R.id.textViewType);
            vh.textViewMaxRange = row.findViewById(R.id.textViewMaxRange);
            vh.textViewResolution = row.findViewById(R.id.textViewResolution);
            vh.textViewPower = row.findViewById(R.id.textViewPower);
            vh.textViewMinDelay = row.findViewById(R.id.textViewMinDelay);
            vh.textViewFifoReservedEventCount = row.findViewById(R.id.textViewFifoReservedEventCount);
            vh.textViewFifoMaxEventCount = row.findViewById(R.id.textViewFifoMaxEventCount);
            vh.textViewVersion = row.findViewById(R.id.textViewVersion);
            vh.textViewReportingMode = row.findViewById(R.id.textViewReportingMode);
            row.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        Sensor sensor = availableSensorsList.get(position);

        vh.textViewId.setText(sensor.getName());
        vh.textViewDesc.setText(sensor.getVendor());
        vh.textViewType.setText("Type: " + sensor.getType());
        vh.textViewMaxRange.setText("Max Range: " + sensor.getMaximumRange());
        vh.textViewResolution.setText("Resolution: " + sensor.getResolution());
        vh.textViewPower.setText("Power: " + sensor.getPower() + " mA");
        vh.textViewMinDelay.setText("Min Delay: " + sensor.getMinDelay() + " µs");
        vh.textViewFifoReservedEventCount.setText("FIFO Reserved Count: " + sensor.getFifoReservedEventCount());
        vh.textViewFifoMaxEventCount.setText("FIFO Max Count: " + sensor.getFifoMaxEventCount());
        vh.textViewVersion.setText("Version: " + sensor.getVersion());
        vh.textViewReportingMode.setText("Reporting Mode: " + sensor.getReportingMode());

        return row;
    }

    @Override
    public int getCount() {
        return (availableSensorsList != null) ? availableSensorsList.size() : 0;
    }

    @Override
    public Sensor getItem(int i) {
        return (availableSensorsList != null) ? availableSensorsList.get(i) : null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
}
