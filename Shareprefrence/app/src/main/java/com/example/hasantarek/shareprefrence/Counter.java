package com.example.hasantarek.shareprefrence;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Hasan Tarek on 10/12/2017.
 */
public class Counter {

    Context context;
    public Counter(Context context) {

        this.context = context;
    }

    public void numcount(int num)
    {
        SharedPreferences sharedPreferences =   context.getSharedPreferences(
                "pref_file",Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("count",num);
        editor.commit();
    }


}