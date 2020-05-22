URL url = new URL(mUpdateUrl);
Log.d(LOG_TAG, "Connect to: " + mUpdateUrl);
HttpURLConnection connection = (HttpURLConnection) url.openConnection();

int response = connection.getResponseCode();

if(response == 200)
{
    BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
    FileOutputStream fs = new FileOutputStream(filename);
    BufferedOutputStream out = new BufferedOutputStream(fs);
    byte [] buffer = new byte[16384];

    int len = 0;
    while ((len = in.read(buffer, 0, 16384)) != -1)
        out.write(buffer, 0, len);

    out.flush();
    in.close();
    out.close();
} else {
    Log.d(LOG_TAG, "Server return code: " + response + ", url: " + url);
    connection.disconnect();
    return null;
}

connection.disconnect();
return filename;