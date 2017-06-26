package com.example.moon.counter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by moon on 2017. 6. 26..
 */

public class SubsList extends AppCompatActivity {
    private ListView listView;
    ArrayList<Substitutes> data = new ArrayList<Substitutes>();
    SubsAdapter subsAdapter;

    @Override
    public void onCreate(Bundle savedInstanceStates) {
        super.onCreate(savedInstanceStates);
        setContentView(R.layout.activity_hansum);

        listView = (ListView)findViewById(R.id.hansum_list);

        data.add(new Substitutes("3세계 빈민 식사대접", 1000, "회"));
        data.add(new Substitutes("짜장면", 5000, "그릇"));
        data.add(new Substitutes("마음의 양식", 10000, "권"));
        data.add(new Substitutes("치킨", 15000, "마리"));
        data.add(new Substitutes("적당한 티셔츠", 30000, "장"));
        data.add(new Substitutes("서울~부산 기차표", 50000, "매"));
        data.add(new Substitutes("괜찮은 호텔", 80000, "일"));
        data.add(new Substitutes("노가다 하루 일당", 100000, "회"));
        data.add(new Substitutes("자취방 월세", 300000, "개월"));
        data.add(new Substitutes("괜찮은 자전거", 500000, "대"));
        data.add(new Substitutes("괜찮은 컴퓨터", 1000000, "대"));
        data.add(new Substitutes("적당한 오토바이", 1500000, "대"));
        data.add(new Substitutes("유럽 왕복 항공권", 2000000, "매"));
        data.add(new Substitutes("프라다 사피아노 퀴르", 2500000, "개"));
        data.add(new Substitutes("코인노래방 부스", 3000000, "개"));
        data.add(new Substitutes("오메가 아쿠아테라", 5000000, "개"));
        data.add(new Substitutes("강남 원룸 보증금", 7000000, "회"));
        data.add(new Substitutes("아반떼 중고", 10000000, "대"));
        data.add(new Substitutes("롤렉스 데이저스트", 12000000, "개"));
        data.add(new Substitutes("부모님 유럽 호화 효도여행", 15000000, "회"));

        subsAdapter = new SubsAdapter(getApplicationContext(), R.layout.activity_hansum, data);
        listView.setAdapter(subsAdapter);

        Button finish = (Button) findViewById(R.id.finish);

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
