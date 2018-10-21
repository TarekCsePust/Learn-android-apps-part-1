package com.example.hasantarek.simpleloginapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Loginactivity extends ActionBarActivity {
    private EditText username;
    private EditText password;
    private Button login;
    int attempt_count = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        onButtonClick();
    }

    public void onButtonClick()
    {
        username = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);
        login = (Button)findViewById(R.id.button);
        final TextView attempt = (TextView)findViewById(R.id.textView5);
        login.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(username.getText().toString().equals("user")
                                && password.getText().toString().equals("pass"))
                        {
                            Toast.makeText(
                                    Loginactivity.this,"correct username and password",
                                    Toast.LENGTH_SHORT
                            ).show();
                            Intent intent = new Intent("com.example.hasantarek.simpleloginapp.Useractivity");
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(
                                    Loginactivity.this,"wrong username and password",
                                    Toast.LENGTH_SHORT
                            ).show();
                            attempt_count--;
                            attempt.setText(Integer.toString(attempt_count));
                            if(attempt_count == 0)
                            {
                                login.setEnabled(false);
                            }
                        }
                    }
                }
        );
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_loginactivity, menu);
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
