package in.sokar.androidweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.Arrays;

public class WeatherActivity extends AppCompatActivity {

    private ListView mWeatherListView = null;
    private Switch   mMetricSwitch = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        //Fetch the references for the UI controls
        getUIControlReferences();

        Integer[] tempData = {40, 50, 75, 89, 120, 55, 71, 89, 92};
        ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(tempData));

        final WeatherAdapter adapter = new WeatherAdapter(getApplicationContext(),
                R.layout.weather_row_layout, R.id.text1, arrayList);
        mWeatherListView.setAdapter(adapter);
    }

    private void getUIControlReferences() {

        mWeatherListView = (ListView)findViewById(R.id.listView);
        mMetricSwitch = (Switch)findViewById(R.id.metricSwitch);
    }
}
