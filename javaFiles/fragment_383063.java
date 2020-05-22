URL obj = new URL(url);//some url
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    con.setDoOutput(true);
    DataOutputStream wr = new DataOutputStream(con.getOutputStream());
    String urlParams = "fName=xyz&lname=ABC&pin=12345"; // some parameters
    wr.writeBytes(urlParams);
    wr.flush();
    wr.close();