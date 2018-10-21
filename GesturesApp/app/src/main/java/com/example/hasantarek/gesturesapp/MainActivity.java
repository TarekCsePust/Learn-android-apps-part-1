package com.example.hasantarek.gesturesapp;

import android.gesture.GestureOverlayView;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.GestureDetector.*;
import android.gesture.Gesture;
import android.view.MotionEvent;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements
        OnGestureListener,OnDoubleTapListener
{

    private TextView text;
    private GestureDetectorCompat gesture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView)findViewById(R.id.textView);
        gesture = new GestureDetectorCompat(this,this);
        gesture.setOnDoubleTapListener(this);
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

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gesture.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        text.setText("onsingaletapconfirmed");
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        text.setText("onDoubletap");
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        text.setText("onDoubletapEvent");
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        text.setText("onDown");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        text.setText("onShow");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        text.setText("onSingletapUp");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        text.setText("onScroll");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        text.setText("onLongpress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        text.setText("onFling");
        return false;
    }
}
