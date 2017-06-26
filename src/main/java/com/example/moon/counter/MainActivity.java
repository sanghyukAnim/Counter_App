package com.example.moon.counter;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.moon.counter.SpendListAdapter.listViewItemList;

public class MainActivity extends AppCompatActivity   {
    static ArrayList<Spends> items = new ArrayList<Spends>();
    static SpendListAdapter adapter;
    static int totalSpend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ListView listview;

        int costToAdd;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Adapter 생성
        adapter = new SpendListAdapter(this, R.layout.listview_item, listViewItemList, new SpendListAdapter.ListBtnClickListener() {
            @Override
            public void onListBtnClick(int position) {
                Intent intent = new Intent(MainActivity.this, Add.class);
                intent.putExtra("aa", position);
                startActivityForResult(intent, 1);
            }
        });

        // 리스트 뷰 참조 및 Adapter 달기
        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);


        adapter.addItem("술", 0);
        adapter.addItem("담배", 0);
        adapter.addItem("택시", 0);

        Button buttonForNewContent = (Button) findViewById(R.id.buttonForNewContent);
        buttonForNewContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ContentAdd.class);
                startActivityForResult(i, 2);
            }
        });


        TextView total = (TextView) findViewById(R.id.textView_total);

        totalSpend = Integer.parseInt(adapter.getItemTotal());
        total.setText(adapter.getItemTotal());
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        setContentView(R.layout.activity_main);
        if(requestCode == 1 || requestCode == 2) {
            if (resultCode == RESULT_OK) {
                ListView listview;
                listview = (ListView) findViewById(R.id.listview1);
                listview.setAdapter(adapter);

                int costToAdd = intent.getIntExtra("asd", 0);
                int pos = intent.getIntExtra("aa", 1);

                adapter = new SpendListAdapter(this, R.layout.listview_item, listViewItemList, new SpendListAdapter.ListBtnClickListener() {
                    @Override
                    public void onListBtnClick(int position) {
                        Intent intent = new Intent(MainActivity.this, Add.class);
                        intent.putExtra("aa", position);
                        startActivityForResult(intent, 1);
                    }
                });

                Button buttonForNewContent = (Button) findViewById(R.id.buttonForNewContent);
                buttonForNewContent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this, ContentAdd.class);
                        startActivityForResult(i, 2);
                    }
                });

                if(requestCode == 2) {
                    String newContentName = intent.getStringExtra("asd");
                    adapter.addItem(newContentName, 0);
                }
                (listViewItemList.get(pos)).setTotal(costToAdd);
                totalSpend = Integer.parseInt(adapter.getItemTotal());

                TextView total = (TextView) findViewById(R.id.textView_total);
                total.setText("총 " + adapter.getItemTotal() + "원...");

                Button hansum = (Button) findViewById(R.id.buttonHansum);
                hansum.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, SubsList.class);
                        startActivityForResult(intent, 1);
                    }
                });

            }
        }
    }
}
