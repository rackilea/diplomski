try {
    HttpClient hc = HttpClientBuilder.create().build();
    HttpGet req = new HttpGet("https://www.google.com");
    HttpResponse res = hc.execute(new HttpHost("8.8.8.8", 443, "https"), req);
    System.out.println(res.getStatusLine());
} catch (Exception e) {
    System.out.println(e.getMessage());
}