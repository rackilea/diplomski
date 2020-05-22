String uri = "data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7";
byte[] decodedString = Base64.decodeBase64(uri.substring(uri.indexOf("data:image/gif;base64,") + "data:image/gif;base64,".length()));
ByteArrayInputStream is = new ByteArrayInputStream(decodedString);
FileOutputStream os = new FileOutputStream(new File("/tmp/test.gif"));

byte[] buffer = new byte[1024];
int length;

// copy the file content in bytes 
while ((length = is.read(buffer)) > 0)
{
    os.write(buffer, 0, length);
}

is.close();
os.close();