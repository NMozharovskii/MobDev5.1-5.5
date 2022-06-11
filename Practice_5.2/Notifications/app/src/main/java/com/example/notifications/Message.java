package com.example.notifications;

import static android.telephony.AvailableNetworkInfo.PRIORITY_HIGH;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class Message extends Service {

    private NotificationManager notificationManager;
    private static final int NOTIFY_ID = 1;
    private static final String CHANNEL_ID = "CHANNEL_ID";

    public Message() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate() {
        super.onCreate();

        Intent notificationIntent = new Intent(this, hello.class);
        PendingIntent pendingIntent =
                PendingIntent.getActivity(this, 0, notificationIntent, 0);

        Intent notificationIntent_1 = new Intent(this, bye.class);
        PendingIntent pendingIntent_1 =
                PendingIntent.getActivity(this, 0, notificationIntent_1, 0);

        Notification notification =
                new Notification.Builder(this, CHANNEL_ID)
                        .setContentTitle("Заголовок")
                        .setContentText("Какой то текст.............")
                        .setSmallIcon(R.drawable.pic2)
                        .setContentIntent(pendingIntent)
                        .addAction(R.drawable.ic_launcher_background, "Кнопка 1", pendingIntent)
                        .addAction(R.drawable.ic_launcher_background, "Кнопка 2", pendingIntent_1)
                        .build();

        startForeground(1, notification);
    }
}