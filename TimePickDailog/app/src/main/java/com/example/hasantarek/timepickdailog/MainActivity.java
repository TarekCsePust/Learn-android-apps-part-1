package com.example.hasantarek.timepickdailog;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private Button btn;
    private final int dailog_id = 0;
    int hour;
    int minite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showTimePickDailog();
    }

    public  void showTimePickDailog()
    {
        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(dailog_id);
                    }
                }
        );
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if(id == dailog_id)
        {
            return new TimePickerDialog(MainActivity.this,kTimePickListner,hour,minite,false);
        }

        return null;
    }




    protected  TimePickerDialog.OnTimeSetListener kTimePickListner =
            new TimePickerDialog.OnTimeSetListener()
           {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    hour = hourOfDay;
                    minite = minute;
                    Toast.makeText(
                            MainActivity.this,hour + ":" + minite,
                            Toast.LENGTH_SHORT
                    ).show();
                }
            };

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
