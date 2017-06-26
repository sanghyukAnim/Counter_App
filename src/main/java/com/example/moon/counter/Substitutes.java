package com.example.moon.counter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by moon on 2017. 6. 26..
 */

public class Substitutes {
    public String title;
    private int cost;

    public Substitutes(String title, int cost) {
        this.title = title;
        this.cost = cost;
    }

    public String getQuotients(int total) {
        Integer q = total/cost;
        return q.toString();
    }
}
