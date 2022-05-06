package es.upm.btb.availablesensors;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;


import java.util.List;

public class MainActivity extends Activity implements SensorEventListener {

	private static final String TAG = "btb";

	private SensorManager sensorManager;

	ListView lvSensorList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		lvSensorList  = (ListView) findViewById(R.id.lv);

		// Read available sensors
		sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		List<Sensor> sensorsList = sensorManager.getSensorList(Sensor.TYPE_ALL);

		SensorListBaseAdapter adapter =  new SensorListBaseAdapter(this, sensorsList);
		lvSensorList.setAdapter(adapter);


		Log.i(TAG, sensorsList.size() +" sensors found:");
		int iCount = 0;
		for (Sensor s : sensorsList) {
			iCount++;
			Log.i(TAG, iCount+". "+s.toString());
		}
		Log.i(TAG, iCount +" sensors listed.");

	}



	protected void onResume() {
		super.onResume();
		//onResume() register the accelerometer to start listening to events
		//sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
	}

	protected void onPause() {
		super.onPause();
		//onPause() unregister the accelerometer to stop listening to events
		//sensorManager.unregisterListener(this);
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) {

	}

}