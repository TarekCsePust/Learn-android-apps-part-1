package com.example.mdhasantarek.mycheckbox;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox check1,check2,check3;
    private Button select;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        addListnerOnClickButton();
        addListnerOnCheckbox();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public  void addListnerOnClickButton()
    {
        check1 = (CheckBox)findViewById(R.id.checkBox);
        check2 = (CheckBox)findViewById(R.id.checkBox2);
        check3 = (CheckBox)findViewById(R.id.checkBox3);
        select = (Button)findViewById(R.id.button);

        select.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        StringBuffer result = new StringBuffer();
                        result.append("Tarek: ").append(check1.isChecked());
                        result.append("\nMITU: ").append(check2.isChecked());
                        result.append("\nLIJA: ").append(check3.isChecked());
                        Toast.makeText(
                                MainActivity.this, result.toString(), Toast.LENGTH_SHORT
                        ).show();
                    }
                }
        );
    }


    public  void addListnerOnCheckbox()
    {
        check1 = (CheckBox)findViewById(R.id.checkBox);
        check1.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        if(((CheckBox)v).isChecked())
                        {
                            Toast.makeText(
                                    MainActivity.this,check1.getText(),Toast.LENGTH_SHORT
                            ).show();
                        }
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
