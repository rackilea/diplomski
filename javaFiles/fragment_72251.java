URL url = null;
try {
    url = new URL(kalturaUrl);
    HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
    if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
        InputStream inputStream = httpConn.getInputStream();
        response.setContentType(httpConn.getContentType());
        response.setContentLength(httpConn.getContentLength());
        response.setHeader("Content-Disposition", httpConn.getHeaderField("Content-Disposition"));
        OutputStream outputStream = response.getOutputStream();

        int bytesRead = -1;
        byte[] buffer = new byte[8192];
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        outputStream.close();
        inputStream.close();
    } else {
        return "No file to download. Server replied HTTP code: " + httpConn.getResponseCode();
    }
    httpConn.disconnect();
} catch (MalformedURLException e) {
    logger.error("Exception : ",e);
} catch (IOException e) {
    logger.error("Exception : ",e);
}