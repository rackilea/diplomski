package com.example.john.weather;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Downloader extends AsyncTask<Void, Void, byte[]> {

String url;
Context mContext;

public Downloader(String _url, Context _context){
    this.url = _url;
    this.mContext = _context;
}

@Override
protected byte[] doInBackground(Void... params) {
    InputStream s;
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    try{
        s = download(this.url);

        /*s.available() can be used only for small downloaded files
        Returns an estimated number of bytes that can be read or skipped without blocking for more input.
        Note that this method provides such a weak guarantee that it is not very useful in practice....*/
        byte[] data = new byte[s.available()];
        int n;
        while ((n = s.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, n);
        }
        buffer.flush();

        return buffer.toByteArray();
    }
    catch (MalformedURLException e) {
        Toast.makeText(mContext, "Ошибка загрузки "+url, Toast.LENGTH_SHORT).show();
        return null; }
    catch (IOException e){
        Toast.makeText(mContext, "Ошибка загрузки "+url, Toast.LENGTH_SHORT).show();
        return null;
    }
}

@Override
protected void onPostExecute(byte[] result) {

}

private InputStream download(String url) throws IOException {
    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
    connection.connect();
    InputStream input = connection.getInputStream();

    return input;
}

}