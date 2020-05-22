public class AudioDownload implements Runnable {

private static Boolean bIAmBusy = false;
private Activity activity;

OnAudioDownloadFinishedListener mycallback;

private final CountDownLatch latch;

private String Folder;
private String FileName;
private String FileUrl;

public AudioDownload(String COURSE_FLAG, String AUDIO, String language, Activity a, CountDownLatch latch){
    Folder = COURSE_FLAG;
    FileName = AUDIO;
    FileUrl = "http://xxx.xx/xxxxx/xxxx/"+ language + "/" + COURSE_FLAG + "/" + FileName;
    activity = a;
    this.latch = latch;
}


@Override
public void run() {
    bIAmBusy = true;
    File localFile = new File(activity.getFilesDir() + "/" + Folder + "/" + FileName);

    if(localFile.exists()){
        //don't download
    }
    else{
        /*
        In older android versions, your Notification has to have a content Intent,
        so that when the user clicks your Notification, something happens. This means you must:
        Make an Intent object, pointing somewhere, such as your MainActivity.
        Make sure to add the Intent.FLAG_ACTIVITY_NEW_TASK flag.
        */

        Intent intent = new Intent(activity, CoursesActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(activity,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);


        NotificationManager notificationManager = (NotificationManager) activity.getSystemService(activity.getApplicationContext().NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(activity);
        builder.setContentTitle("Audio Download");
        builder.setContentText("Download in Progress");
        builder.setSmallIcon(R.drawable.btn_download);
        builder.setTicker("Audio Download");
        builder.setContentIntent(pendingIntent);

        int id = 1;

        BufferedInputStream in = null;
        FileOutputStream out = null;

        boolean saved = false;
        try {
            URL url = new URL(FileUrl);
            URLConnection conn = url.openConnection();
            int size = conn.getContentLength();

            in = new BufferedInputStream(new URL(FileUrl).openStream());

            final File dir = new File(activity.getFilesDir() + "/" + Folder);
            dir.mkdirs();
            final File file = new File(dir,FileName);

            out = new FileOutputStream(file);

            final byte data[] = new byte[1024];
            int count;
            int sumCount = 0;


            while ((count = in.read(data, 0, 1024)) != -1) {
                sumCount += count;
                builder.setProgress(size,sumCount,false);
                notificationManager.notify(id, builder.build());
                out.write(data, 0, count);

            }
            saved = true;
            builder.setContentText("Download Complete");
            builder.setProgress(0,0,false);
            notificationManager.notify(id, builder.build());

        }catch (IOException e){

        }
        finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        final boolean finalSaved = saved;
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mycallback.OnAudioDownloadThreadFinished(finalSaved);
            }
        });
    }
    latch.countDown();
    bIAmBusy = false;
}

public interface OnAudioDownloadFinishedListener{
    void OnAudioDownloadThreadFinished(Boolean success);
}

public void setOnAudioDownloadFinishedListener(OnAudioDownloadFinishedListener listener){
    mycallback = listener;
}

public Boolean isBusy() {
    return bIAmBusy;
}
}