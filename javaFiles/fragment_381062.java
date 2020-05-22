public static void main(String[] args) throws IOException {

    URL url = new URL("http", "localhost:8080", "/Myproject/TestServletUpdated");

    URLConnection conn = url.openConnection();
    conn.setDoOutput(true);

    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
    wr.write("command=startTask" +
             "&taskeId=" +taskId +
             "&jsonInput={\"result\":" + URLEncoder.encode(tmp) + "}");
    wr.flush();


    .... handle the answer ...
}