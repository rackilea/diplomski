public class StartDownloadReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        boolean autoDownload = sharedPreferences.getBoolean("auto_download", false);
        if (autoDownload) {
            context.startService(new Intent(context, DownloaderService.class));    
        }

    }

}