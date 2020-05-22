import io.netty.buffer.Unpooled;
import java.nio.file.Files;
import java.nio.file.Paths;

response.setContentType("application/pdf"); //Setting content type to be pdf
response.addHeader("Content-disposition", "attachment; filename=" + outputFileAddress);
LOG.info(outputFileAddress);       
java.nio.file.Path path = Paths.get(outputFileAddress);
byte[] data = Files.readAllBytes(path);
response.setBody(Unpooled.wrappedBuffer(data));
response.noSerialization(); // No serialization avoids getting the stream to Jackson
response.setResponseStatus(HttpResponseStatus.OK);