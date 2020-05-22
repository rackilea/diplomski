import com.ning.http.client.AsyncHttpClient
import com.ning.http.client.multipart.FilePart

AsyncHttpClient myClient = ws.getUnderlying();
FilePart myFilePart = new FilePart("myFile", new java.io.File("test.txt"))
myClient.preparePut("http://localhost:9000/index").addBodyPart(filePart).execute.get()