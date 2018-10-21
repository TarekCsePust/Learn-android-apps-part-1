package com.example.hasantarek.service1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by Hasan Tarek on 6/4/2017.
 */
public class TheService extends Service {

    final class Thethread extends Thread {

        int serviceId;
        Thethread (int serviceId)
        {
            this.serviceId = serviceId;
        }

        @Override
        public void run() {

            synchronized (this)
            {
                try {
                    wait(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            stopSelf(this.serviceId);
        }
    }


    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(
                TheService.this,"start service",Toast.LENGTH_SHORT
        ).show();

        Thread thread = new Thread(new Thethread(startId));
        thread.start();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(
                TheService.this,"destroy service",Toast.LENGTH_SHORT
        ).show();
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
