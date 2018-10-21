package com.example.hasantarek.datepickdialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.provider.CalendarContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;


public class MainActivity extends ActionBarActivity {
    private Button btn;
    private  int month_x,day_x,year_x;
    private final int dialog_id =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Calendar cln = Calendar.getInstance();
        year_x = cln.get(Calendar.YEAR);
        month_x = cln.get(Calendar.MONTH);
        day_x  = cln.get(Calendar.DAY_OF_MONTH);
        dialogpicker();
    }

    public void dialogpicker()
    {
        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(dialog_id);
                    }
                }
        );
    }

    @Override
    protected Dialog onCreateDialog(int id) {

        if(id == dialog_id)
        {
            return new DatePickerDialog(MainActivity.this,DpickerListner,year_x,month_x,day_x);
        }
        return null;
    }

    protected DatePickerDialog.OnDateSetListener DpickerListner =
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    day_x = dayOfMonth;
                    year_x = year;
                    month_x= monthOfYear +1;
                    Toast.makeText(
                            MainActivity.this,day_x + "/" + month_x + "/" + year_x,
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
