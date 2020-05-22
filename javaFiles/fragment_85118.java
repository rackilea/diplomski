String url = "http://maniv.com/maniv/rest";
    String charset = "UTF-8";
    String method = "sendMessage";
    String msg_type = "binary";
    String parameter1 = "9999999";
    String parameter2 = "0000000";
    String msg = "001100110001100011";

    // ...
    StringBuffer sb = null;
    String query = String
            .format("method=%s&msg_type=%s&userid=%s&password=%s&msg=%s",
                    URLEncoder.encode(method, charset),
                    URLEncoder.encode(msg_type, charset),
                    URLEncoder.encode(userid, charset),
                    URLEncoder.encode(password, charset),
                    URLEncoder.encode(msg, charset));
    try {
        URL requestUrl = new URL(url + "?" + query);
        HttpURLConnection conn = (HttpURLConnection) requestUrl.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("GET");
        OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
        osw.write(query);
        osw.flush();
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String in = "";
        sb = new StringBuffer();
        while ((in = br.readLine()) != null) {
            sb.append(in + "\n");
            System.out.println("Output:\n" +in);
        }
    } catch (Exception e) {
        System.out.println("Exception occured" + e);
    }
}