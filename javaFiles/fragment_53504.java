override fun onDestroy() {
    super.onDestroy()

    abandonAudioFocus()
    unregisterReceiver(mNoisyReceiver)

    //Deactivate session
    mSession.isActive = false
    mSession.release()

    NotificationManagerCompat.from(this).cancelAll()

    if(mWiFiLock?.isHeld == true) mWiFiLock?.release()

    stopForeground(true)
}