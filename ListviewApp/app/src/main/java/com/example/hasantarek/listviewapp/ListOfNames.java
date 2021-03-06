package com.example.hasantarek.listviewapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class ListOfNames extends ActionBarActivity {

    private ListView listview;
    private String names[] = {"Hasan","Tarek","Mitu","Lija","Nasima","Morsalim"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_names);
        listclick();
    }

    public void listclick()
    {
        listview = (ListView)findViewById(R.id.listView);
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this,R.layout.names,names);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String value = (String)listview.getItemAtPosition(position);
                        Toast.makeText(
                                ListOfNames.this,"position:" + position +  " value:" + value,
                                Toast.LENGTH_SHORT
                        ).show();
                    }
                }
        );
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_of_names, menu);
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
