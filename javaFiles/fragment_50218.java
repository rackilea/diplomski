URL url = new URL("http://IP/lcmw");
HttpURLConnection con = (HttpURLConnection) url.openConnection();
con.setRequestMethod("POST");
con.setRequestProperty("Content-type", "text/xml");
con.setDoOutput(true);
try(FileInputStream fs = new FileInputStream("login.xml")) {
    byte buf[] = new byte[1000];
    int bytes = 0;
    while( (bytes = fs.read(buf)) > 0) {
        con.getOutputStream().write(buf,0,bytes);
    }
}
con.getOutputStream().flush();
int responseCode = con.getResponseCode();
System.out.println("responseCode = " + responseCode);
try(BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
    br.lines().forEach(System.out::println);
}