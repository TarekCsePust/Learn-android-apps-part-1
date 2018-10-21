package com.example.hasantarek.sqlitapp1;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private Databasehelper myDb;
    private EditText editname,editroll,editmark,editid;
    private Button add;
    private Button viewData;
    private Button updt;
    private Button dlt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new Databasehelper(this);
        editname = (EditText)findViewById(R.id.editText);
        editroll = (EditText)findViewById(R.id.editText2);
        editmark = (EditText)findViewById(R.id.editText3);
       // editmark.setText("25");
        editid = (EditText)findViewById(R.id.editText4);
        add = (Button)findViewById(R.id.button);
        viewData = (Button)findViewById(R.id.button2);
        updt = (Button)findViewById(R.id.button3);
        dlt = (Button)findViewById(R.id.button4);
        adddata();
    }

    public  void adddata()
    {
        add.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       boolean Isinerted =  myDb.insertData(editname.getText().toString()
                               ,editroll.getText().toString()
                        ,editmark.getText().toString());

                        if(Isinerted == true)
                        {
                            Toast.makeText(
                                    MainActivity.this,"Data inserted",Toast.LENGTH_SHORT
                            ).show();
                        }
                        else
                        {
                            Toast.makeText(
                                    MainActivity.this,"Data not inserted",Toast.LENGTH_SHORT
                            ).show();
                        }
                    }
                }
        );


        viewData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res =myDb.getallData();
                        if (res.getCount()==0)
                        {
                            showMassage("Error","Nothing found");
                            return;
                        }

                        StringBuffer data = new StringBuffer();
                        while (res.moveToNext())
                        {
                            data.append("id: " + res.getString(0) + "\n");
                            data.append("name: " + res.getString(1) + "\n");
                            data.append("roll: " + res.getString(2) + "\n");
                            data.append("mark: " + res.getString(3) + "\n\n");
                        }

                        showMassage("Data",data.toString());
                    }
                }
        );

        updt.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        boolean IsUpdate =  myDb.updatedata(editid.getText().toString(), editname.getText().toString()
                                , editroll.getText().toString()
                                , editmark.getText().toString());
                        if(IsUpdate == true)
                        {
                            Toast.makeText(
                                    MainActivity.this,"updated",Toast.LENGTH_SHORT
                            ).show();
                        }
                        else
                        {
                            Toast.makeText(
                                    MainActivity.this,"not updated",Toast.LENGTH_SHORT
                            ).show();
                        }
                    }
                }
        );


        dlt.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int IsDalete = myDb.deletedata(editid.getText().toString());
                        if(IsDalete >0)
                        {
                            Toast.makeText(
                                    MainActivity.this,"Deleted",Toast.LENGTH_SHORT
                            ).show();
                        }
                        else
                        {
                            Toast.makeText(
                                    MainActivity.this,"Not deleted",Toast.LENGTH_SHORT
                            ).show();
                        }
                    }
                }
        );
    }


    public void showMassage(String title,String Massage)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Massage);
        builder.show();
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
