package com.example.hasantarek.service2;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.util.Pools;
import android.widget.Toast;

/**
 * Created by Hasan Tarek on 6/4/2017.
 */
public class Myservice extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public Myservice() {

        super("my_intent_thread");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(
                Myservice.this,"start service",Toast.LENGTH_SHORT
        ).show();
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {

        Toast.makeText(
                Myservice.this,"destroy service",Toast.LENGTH_SHORT
        ).show();

        super.onDestroy();

    }

    @Override
    protected void onHandleIntent(Intent intent) {

        synchronized (this)
        {
            try {
                wait(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
