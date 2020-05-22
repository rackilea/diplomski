public boolean log(String logURL) {

    String charset = "UTF-8";
    String logData = logBuffer.toString();
    OutputStream output = null;
    HttpURLConnection conn = null;
    BufferedReader reader = null;
    InputStream in = null;

    try {
        String query = String.format("log=%s", URLEncoder.encode(logData, charset));
        conn = (HttpURLConnection) new URL(logURL).openConnection();
        conn.setDoOutput(true);
        conn.setRequestProperty("Accept-Charset", charset);
        conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded;charset=" + charset);
        output = conn.getOutputStream();
        output.write(query.getBytes(charset));

    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
        return false;
    } catch (MalformedURLException e) {
        e.printStackTrace();
        return false;
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    } finally {
         if (output != null) try { output.close(); } catch (IOException e) {e.printStackTrace();}
    }

    // Handle the response
    try {
        int responseCode = conn.getResponseCode();
        if (responseCode == 200) {
            in = conn.getInputStream();
        } else {
            in = conn.getErrorStream();
        }
        reader = new BufferedReader(new InputStreamReader(in));
        String line;
        logNote("reading response");
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();         
        if (responseCode == 200) {
            return true;
            }
        else {
            return false;
        }

    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
        return false;
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    } finally {
        if (reader != null) try { reader.close(); } catch (IOException e) {e.printStackTrace();}
    }   
}