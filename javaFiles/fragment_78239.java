public static void main(String[] args) throws Exception {
    Socket s = new Socket(InetAddress.getByName("google.com"), 80);
    PrintWriter pw = new PrintWriter(s.getOutputStream());
    pw.println("GET /about/ HTTP/1.1"); // here comes the path
    pw.println("f-Modified-Since: Wed, 1 Oct 2017 07:00:00 GMT");
    pw.println("");
    pw.flush();
    BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    String line;
    while((line = br.readLine()) != null){
        System.out.println(line);
    }
    br.close();
}