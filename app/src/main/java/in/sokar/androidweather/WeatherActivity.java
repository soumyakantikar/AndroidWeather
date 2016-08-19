package in.sokar.androidweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.Arrays;

public class WeatherActivity extends AppCompatActivity {

    private ListView mWeatherListView = null;
    private Switch   mMetricSwitch = null;
    private WeatherAdapter weatherAdapter = null;

    private Integer[] tempData = {40, 50, 75, 89, 120, 55, 71, 89, 92};
    private ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(tempData));

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        //Fetch the references for the UI controls
        getUIControlReferences();

        weatherAdapter = new WeatherAdapter(getApplicationContext(),
                R.layout.weather_row_layout, R.id.text1, arrayList);
        mWeatherListView.setAdapter(weatherAdapter);

        mMetricSwitch.setOnCheckedChangeListener(metricChangeListener);
    }

    private void getUIControlReferences() {

        mWeatherListView = (ListView)findViewById(R.id.listView);
        mMetricSwitch = (Switch)findViewById(R.id.metricSwitch);
    }

    private CompoundButton.OnCheckedChangeListener metricChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            if(isChecked) {
                Log.d("App", "The metric has been enabled");
                Integer i[] = new Integer[9];
                for(int index = 0; index < tempData.length; index++) {
                    i[index] = ((tempData[index] - 32) / 2);
                    Log.d("App", "The converted temp is: " + i[index]);
                }
                arrayList = new ArrayList<Integer>(Arrays.asList(i));
                weatherAdapter.notifyDataSetChanged();
            } else {
                Log.d("App", "The metric has been displayed");
                arrayList = new ArrayList<Integer>(Arrays.asList(tempData));
                weatherAdapter.notifyDataSetChanged();
            }
        }
    };
}
