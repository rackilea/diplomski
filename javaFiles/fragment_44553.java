//First param is a Bitmap, second is quality
JPEGEncodedImage encodedImage = JPEGEncodedImage.encode(image, 100);
byte imageBytes[]=encodedImage.getData();

//The HTTP connection stuff
HttpConnection conn = (HttpConnection) Connector.open(SERVER_URL, Connector.READ_WRITE);
conn.setRequestProperty(HttpProtocolConstants.HEADER_CONTENT_TYPE, HttpProtocolConstants.CONTENT_TYPE_MULTIPART_FORM_DATA);
conn.setRequestMethod(HttpConnection.POST);
conn.setRequestProperty(HttpProtocolConstants.HEADER_CONTENT_LENGTH, String.valueOf(imageBytes.length));
//Change this part to what your server side code expects
String contDisp="Content-Disposition:form-data; uploadedimage=YOUR_IMAGE_NAME;filename=\"Image.jpg\"";
String contEnc = "Content-Transfer-Encoding: binary";
String type="Content-Type:image/jpeg";

OutputStream out= conn.openOutputStream();
out.write(imageBytes);
out.flush();
out.close();