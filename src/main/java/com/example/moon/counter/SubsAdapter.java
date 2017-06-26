package com.example.moon.counter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

import static com.example.moon.counter.MainActivity.totalSpend;

/**
 * Created by moon on 2017. 6. 26..
 */

public class SubsAdapter extends BaseAdapter {
    private Context context = null;
    private int layout = 0;
    private ArrayList<Substitutes> data = null;
    private LayoutInflater inflater = null;

    public SubsAdapter(Context c, int l, ArrayList<Substitutes> d) {
        this.context = c;
        this.layout = l;
        this.data = d;
        this.inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.listview_subs, parent, false);
        }
        TextView Title = (TextView) convertView.findViewById(R.id.subsName);
        TextView Q = (TextView) convertView.findViewById(R.id.subsCost);

        Title.setText(data.get(position).title);
        Q.setText(data.get(position).getQuotients(totalSpend) + data.get(position).unitName);

        return convertView;
    }
}
