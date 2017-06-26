package com.example.moon.counter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;

/**
 * Created by moon on 2017. 6. 7..
 */

public class SpendListAdapter extends ArrayAdapter implements View.OnClickListener {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
     public static ArrayList<Spends> listViewItemList = new ArrayList<Spends>();

    // SpendListAdapter의 생성자
    SpendListAdapter(Context context, int resource, ArrayList<Spends> list, ListBtnClickListener clickListner) {
        super(context, resource, list);
        this.resourceId = resource;
        this.listBtnClickListener = clickListner;
    }

    @Override
    public void onClick(View v) {
        if(this.listBtnClickListener != null) {
            this.listBtnClickListener.onListBtnClick((int)v.getTag());
        }
    }

    public interface ListBtnClickListener {
        void onListBtnClick(int position);
    }

    int resourceId;
    private ListBtnClickListener listBtnClickListener;
    // Adapter에 사용되는 데이터의 개수를 리턴 (필수)
    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴 (필수)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final int pos = position;
        final Context context = parent.getContext();

        // Layout을 inflate하여 convertView 참조 획득
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }

        // 화면에 표시될 View로부터 위에 대한 참조 획득
        TextView titleTextView = (TextView) convertView.findViewById(R.id.textView1);
        TextView descTextView = (TextView) convertView.findViewById(R.id.textView2);


        // Data Set(SpendListAdapter)에서 position에 위치한 데이터 참조 획득
        Spends listViewitem = listViewItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        titleTextView.setText(listViewitem.getName());
        descTextView.setText("총 " + listViewitem.toString() + "원");

        //button 1
        Button button1 = (Button) convertView.findViewById(R.id.button1);
        button1.setTag(position);
        button1.setOnClickListener(this);

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    public void addItem(String title, int desc) {
        Spends item = new Spends(title);
        item.setTotal(desc);

        listViewItemList.add(item);
    }

    public String getItemTotal() {
        Integer total = 0;
        for(Spends sp : listViewItemList) {
            total += sp.total;
        }
        return Integer.toString(total);
    }

}