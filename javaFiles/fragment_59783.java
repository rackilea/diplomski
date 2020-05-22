MultipartEntity multipart = new MultipartEntity();
File file = new File("/filepath");  // File with some location (filepath)
Charset chars = Charset.forName("UTF-8"); // Setting up the encoding
FileBody fileB = new FileBody(file); // Create a new FileBody with the above mentioned file
multipart.addPart("data", fileB); // Add the part to my MultipartEntity. "data" is parameter name for the file
StringBody stringB;  // Now lets add some extra information in a StringBody
try {
    stringB = new StringBody("I am the caption of the file",chars);  // Adding the content to the StringBody and setting up the encoding
    multipart.addPart("caption", stringB); // Add the part to my MultipartEntity
} catch (UnsupportedEncodingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}

HttpPost post = new HttpPost(url); // Setting up a HTTP Post method with the target url
post.setEntity(multipart); // Setting the multipart Entity to the post method
HttpResponse resp = client.execute(post);  // Using some HttpClient (I'm using DefaultHttpClient) to execute the post method and receive the response