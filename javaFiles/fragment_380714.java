@RequestMapping(path = "/downloadFile", method = RequestMethod.GET) 
public ResponseEntity download(String param) throws IOException { 
    String testFileName = "https://www.google.co.jp/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png" 
    HttpClient client = HttpClientBuilder.create().build();
    HttpGet request = new HttpGet(testFileName);

    request.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
    request.setHeader("Pragma", "no-cache"); 
    request.setHeader("Expires", "0");

    HttpResponse response = client.execute(request);
    if (response.getStatusLine().getStatusCode()==200) {
    ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

    return ResponseEntity.ok()
        .headers(headers)
        .contentLength(file.length())
        .contentType(MediaType.parseMediaType("application/octet-stream"))
        .body(response.getEntity().getContent());
    } else {
        return ResponseEntity.notFound();
    }
}