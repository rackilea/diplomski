private fun compileNotification(context: Context, action: NotificationCompat.Action, mediaSession: MediaSessionCompat, controller: MediaControllerCompat, mMetadata: MediaMetadataCompat, art: Bitmap?, mPlaybackState: PlaybackStateCompat) {

    val description = mMetadata.description

    // https://stackoverflow.com/questions/45395669/notifications-fail-to-display-in-android-oreo-api-26
    @TargetApi(26)
    if(Utils.hasO()) {
        val channelA = mNotificationManager?.getNotificationChannel(NotificationChannelID.MEDIA_SERVICE.name)

        if(channelA == null) {
            val channelB = NotificationChannel(NotificationChannelID.MEDIA_SERVICE.name,
                    "MediaService",
                    NotificationManager.IMPORTANCE_DEFAULT)
            channelB.setSound(null, null)

            mNotificationManager?.createNotificationChannel(channelB)
        }
    }

    val notificationBuilder = if(Utils.hasLollipop()) {
        NotificationCompat.Builder(context, NotificationChannelID.MEDIA_SERVICE.name)
    } else {
        NotificationCompat.Builder(context)
    }

    notificationBuilder
            .setStyle(android.support.v4.media.app.NotificationCompat.MediaStyle()
                    // Show actions 0,2,4 in compact view
                    .setShowActionsInCompactView(0,2,4)
                    .setMediaSession(mediaSession.sessionToken))
            .setSmallIcon(R.drawable.logo_icon)
            .setShowWhen(false)
            .setContentIntent(controller.sessionActivity)
            .setContentTitle(description.title)
            .setContentText(description.description)
            .setLargeIcon(art)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            .setOngoing(mPlaybackState.state == PlaybackStateCompat.STATE_PLAYING)
            .setOnlyAlertOnce(true)

            if(!Utils.hasLollipop()) {
                notificationBuilder
                        .setStyle(android.support.v4.media.app.NotificationCompat.MediaStyle()
                                // Show actions 0,2,4 in compact view
                                .setShowActionsInCompactView(0,2,4)
                                .setMediaSession(mediaSession.sessionToken)
                                .setShowCancelButton(true)
                                .setCancelButtonIntent(MediaButtonReceiver.buildMediaButtonPendingIntent(context,
                                        PlaybackStateCompat.ACTION_STOP)))
                        // Stop the service when the notification is swiped away
                        .setDeleteIntent(MediaButtonReceiver.buildMediaButtonPendingIntent(context,
                                PlaybackStateCompat.ACTION_STOP))
            }

    notificationBuilder.addAction(NotificationCompat.Action(
            R.drawable.exo_controls_previous,
            "Previous",
            MediaButtonReceiver.buildMediaButtonPendingIntent(context,
                    PlaybackStateCompat.ACTION_SKIP_TO_PREVIOUS)))
    notificationBuilder.addAction(NotificationCompat.Action(
            R.drawable.ic_replay_10_white_24dp,
            "Rewind",
            MediaButtonReceiver.buildMediaButtonPendingIntent(context,
                    PlaybackStateCompat.ACTION_REWIND)))

    notificationBuilder.addAction(action)

    notificationBuilder.addAction(NotificationCompat.Action(
            R.drawable.ic_forward_10_white_24dp,
            "Fast Foward",
            MediaButtonReceiver.buildMediaButtonPendingIntent(context,
                    PlaybackStateCompat.ACTION_FAST_FORWARD)))
    notificationBuilder.addAction(NotificationCompat.Action(
            R.drawable.exo_controls_next,
            "Next",
            MediaButtonReceiver.buildMediaButtonPendingIntent(context,
                    PlaybackStateCompat.ACTION_SKIP_TO_NEXT)))

    (context as MediaService).startForeground(NOTIFICATION_ID, notificationBuilder.build())
}