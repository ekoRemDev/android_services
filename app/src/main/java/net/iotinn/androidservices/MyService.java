package net.iotinn.androidservices;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.widget.Toast;

import java.util.Random;

public class MyService extends Service {


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                displayData();
            }
        }, 5000);



        return START_STICKY;
    }

    private void displayData() {
//        Toast.makeText(this, "Service started by user.", Toast.LENGTH_LONG).show();


        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
// Vibrate for 500 milliseconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            v.vibrate(500);
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        Toast.makeText(this, "Service destroyed by user.", Toast.LENGTH_LONG).show();
    }



}
