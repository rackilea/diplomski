URL url = new URL("http://localhost:8080/uploadfiles");
    HttpURLConnection con = (HttpURLConnection)uploadUrl.openConnection();
    try {
        con.setDoOutput(true);
        con.setRequestMethod("POST");
        con.addRequestProperty("Authorization",
                "Basic " + encode64(username + ":" + password));
        OutputStream out = con.getOutputStream();
        try {
            InputStream in = new FileInputStream(inFile);
            try {
                byte buffer[] = new byte[4096];
                for (int n = in.read(buffer); n > 0; n = in.read(buffer)) {
                    out.write(buffer, 0, n);
                }
            } finally {
                in.close();
            }
        } finally {
            out.close();
        }
        int code = con.getResponseCode();
        if (code != HttpURLConnection.HTTP_OK) {
            String msg = con.getResponseMessage();
            throw new IOException("HTTP Error " + code + ": " + msg);
        }
    } finally {
        con.disconnect();
    }