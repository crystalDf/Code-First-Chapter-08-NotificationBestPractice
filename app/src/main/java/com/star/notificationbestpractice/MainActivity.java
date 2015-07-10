package com.star.notificationbestpractice;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 0;
    public static final int NOTIFICATION_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendNotice = (Button) findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager notificationManager =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                PendingIntent pendingIntent = PendingIntent.getActivity(
                        MainActivity.this, REQUEST_CODE,
                        new Intent(MainActivity.this, NotificationActivity.class),
                        PendingIntent.FLAG_CANCEL_CURRENT);

                Notification notification = new Notification.Builder(MainActivity.this)
                        .setContentIntent(pendingIntent)
                        .setContentTitle("This is content title")
                        .setContentText("This is content text")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setWhen(System.currentTimeMillis())
                        .setContentInfo("info")
                        .setAutoCancel(true)
                        .setSound(Uri.parse(
                                "file:///storage/emulated/0/BaiduNetdisk/" +
                                        "Taylor Swift-Safe And Sound.mp3"))
                        .setVibrate(new long[]{0, 1000, 1000, 1000})
                        .setLights(Color.GREEN, 1000, 1000)
                        .build();

                notificationManager.notify(NOTIFICATION_ID, notification);

            }
        });
    }


}
