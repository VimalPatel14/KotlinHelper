package com.vimal.myapplication.firebase

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {


    override fun onNewToken(p0: String) {
        Log.d("Firebase", "New Tag: $p0")
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.d("Firebase", "Remote message: $remoteMessage")

        val notification = remoteMessage.notification

        notification?.let {
            val title = it.title
            val body = it.body

            pushNotification(title, body)
        }
    }
    private fun pushNotification(title: String?, body: String?){
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channelId = "Push Notification"
        val channelName = "Push Ocean"
        val channelDescription = "Notificação"
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId,channelName,NotificationManager.IMPORTANCE_DEFAULT).apply{
                description = channelDescription
            }
            notificationManager.createNotificationChannel(channel)
        }
        val notificationBuilder = NotificationCompat.Builder(this,channelId)
            .setContentTitle(title)
            .setContentText(body)
            .setSmallIcon(android.R.drawable.ic_dialog_alert)
        val notification = notificationBuilder.build()
        val notificationId = 1
        notificationManager.notify(notificationId, notification)
    }

}