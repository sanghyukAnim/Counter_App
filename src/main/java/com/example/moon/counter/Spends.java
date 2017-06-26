package com.example.moon.counter;

import android.graphics.drawable.Drawable;

/**
 * Created by moon on 2017. 6. 7..
 */

public class Spends {
    private String name;
    public int total;

    public Spends(String name) {
        this.name = name;
    }

    public void setTotal(int total) {
        this.total = this.total+total;
    }

    public String getName() {
        return this.name;
    }
    public int getTotal() {
        return this.total;
    }
    @Override
    public String toString() {
        Integer num = total;
        String str = Integer.toString(num);
        return str;
    }
}
