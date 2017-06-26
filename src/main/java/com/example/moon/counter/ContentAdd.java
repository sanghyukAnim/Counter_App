package com.example.moon.counter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by moon on 2017. 6. 26..
 */

public class ContentAdd extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        Button buttonContent = (Button)findViewById(R.id.buttonContent);
        TextView TitleText = (TextView) findViewById(R.id.TitleText2);

        buttonContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                EditText editText = (EditText) findViewById(R.id.editTextContent);
                String strNo = editText.getText().toString();

                intent.putExtra("asd", strNo);

                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
