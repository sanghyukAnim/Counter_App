package com.example.moon.counter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.moon.counter.MainActivity.items;

/**
 * Created by moon on 2017. 6. 7..
 */

public class Add extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Button buttonSave = (Button) findViewById(R.id.buttonSave);
        TextView textView = (TextView) findViewById(R.id.TitleText);
        textView.setText("금액 추가");
        int position = getIntent().getIntExtra("aa", 0);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                int position = getIntent().getIntExtra("aa", 0);

                EditText editTextNo = (EditText) findViewById(R.id.editText);
                String strNo = (editTextNo.getText()).toString();

                int costToAdd = Integer.parseInt(strNo);
                intent.putExtra("asd", Integer.parseInt(strNo));
                intent.putExtra("aa", position);

                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
