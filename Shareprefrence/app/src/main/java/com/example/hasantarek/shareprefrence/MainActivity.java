package com.example.hasantarek.shareprefrence;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Counter counter;
    int count=70000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.text);
        Toast.makeText(getApplicationContext(),count+"",Toast.LENGTH_SHORT).show();
        counter = new Counter(getApplicationContext());
        /*SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(
                getString(R.string.pref_file),MODE_PRIVATE
        );*/
        SharedPreferences sharedPreferences =getApplicationContext().getSharedPreferences(
                "pref_file", Context.MODE_PRIVATE);


        //count = sharedPreferences.getInt(getString(R.string.count),0);
        count = sharedPreferences.getInt("count",0);
        textView.setText("count " + count);
    }

    public void increment(View view)
    {
        count++;
        counter.numcount(count);
        textView.setText("count " + count);

    }

  /* public void numcount(int num)
    {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(
                getString(R.string.pref_file),MODE_PRIVATE
        );

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(getString(R.string.count),num);
        editor.commit();
    }*/
}
