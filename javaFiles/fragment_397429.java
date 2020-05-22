URL url = new URL("https://www.google.com");
HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
conn.connect();

for(Certificate crt : conn.getServerCertificates()) {
    System.out.println(crt);
}