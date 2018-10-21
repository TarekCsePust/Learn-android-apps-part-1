package com.example.hasantarek.seekbarapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private SeekBar seek_bar;
    private TextView text_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekber_method();
    }

    public void seekber_method()
    {
        seek_bar = (SeekBar)findViewById(R.id.seekBar);
        text_view = (TextView)findViewById(R.id.textView);
        text_view.setText("coverd: " + seek_bar.getProgress() + "/" + seek_bar.getMax());
        seek_bar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener()
                {
                    int progress_value;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        progress_value = progress;
                        text_view.setText("coverd: " + seek_bar.getProgress() + "/" + seek_bar.getMax());
                        Toast.makeText(
                                MainActivity.this,"seekbar in progress",
                                Toast.LENGTH_SHORT
                        ).show();
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                        Toast.makeText(
                                MainActivity.this,"seekbar Startprogress",
                                Toast.LENGTH_SHORT
                        ).show();
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                        Toast.makeText(
                                MainActivity.this,"seekbar  Stopprogress",
                                Toast.LENGTH_SHORT
                        ).show();
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
