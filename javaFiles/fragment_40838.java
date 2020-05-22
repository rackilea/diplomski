MultipartEntityBuilder builder = MultipartEntityBuilder.create();        

/* example for setting a HttpMultipartMode */
builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

/* example for adding an image part */
FileBody fileBody = new FileBody(new File(image)); //image should be a String
builder.addPart("my_file", fileBody); 
//and so on