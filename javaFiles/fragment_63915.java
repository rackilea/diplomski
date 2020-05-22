public static void main(String args[]) throws IOException{
    URL url = new URL("http://www.google.com");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    String contentType = connection.getContentType();
    System.out.println("content-type: " + contentType);
    IOUtils.copy(connection.getInputStream(), new FileOutputStream("/temp/test.html"));
}