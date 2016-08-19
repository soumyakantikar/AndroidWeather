package in.sokar.androidweather;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by karsk on 8/19/2016.
 */
public class WeatherAdapter extends ArrayAdapter<Integer> {

    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

    public WeatherAdapter(Context context, int layoutId, int textId, List<Integer> objects) {
        super(context, layoutId, textId, objects);
        for (int i = 0; i < objects.size(); ++i) {
            mIdMap.put(((Integer)i).toString(), i);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = super.getView(position, convertView, parent);
        TextView textView=(TextView) view.findViewById(R.id.text1);
        textView.setTextColor(Color.BLUE);
        return view;
    }
}
