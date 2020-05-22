URL url = new URL("http://localhost:8080/uploadfiles");
    HttpURLConnection con = (HttpURLConnection)url.openConnection();
    try {
        con.addRequestProperty("Authorization",
                "Basic " + encode64(username + ":" + password));
        InputStream in = con.getInputStream();
        try {
            OutputStream out = new FileOutputStream(outFile);
            try {
                byte buf[] = new byte[4096];
                for (int n = in.read(buf); n > 0; n = in.read(buf)) {
                    out.write(buf, 0, n);
                }
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    } finally {
        con.disconnect();
    }