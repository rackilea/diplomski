package ir.negano.Downloader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import android.os.Handler;


public class Downloader {
public static final Handler HANDLER = new Handler();
static Thread               DownloadThread;


public static interface OnDownloadMoveListener {

    public void onRun(int FileSize, int DownloadedSize, int DownloadedPersent);
}


public static void Download(final String onlineFilePath, final String localFilePath, final OnDownloadMoveListener DownloadListener) {
    DownloadThread = new Thread(new Runnable() {

        int DownloadedSize    = 0;
        int DownloadedPersent = 0;


        @Override
        public void run() {
            try {
                URL url = new URL(onlineFilePath);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setDoOutput(true);
                connection.connect();
                final int FileSize = connection.getContentLength();

                InputStream inputStream = connection.getInputStream();
                FileOutputStream OutPutStream = new FileOutputStream(localFilePath);
                byte[] buffer = new byte[8 * 1024];
                int len = 0;
                while ((len = inputStream.read(buffer)) > 0) {
                    OutPutStream.write(buffer, 0, len);
                    DownloadedSize += len;
                    DownloadedPersent = (int) (((float) DownloadedSize / FileSize) * 100);
                    if (DownloadListener != null)
                    {
                        HANDLER.post(new Runnable() {

                            @Override
                            public void run() {
                                DownloadListener.onRun(FileSize, DownloadedSize, DownloadedPersent);
                            }
                        });

                    }
                    if (DownloadedPersent >= 100)
                    {
                        DownloadThread = null;
                    }
                }
                OutPutStream.close();
            }
            catch (MalformedURLException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    });
    DownloadThread.start();

}