import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPOutputStream;

ByteArrayOutputStream bos = new ByteArrayOutputStream();
GZIPOutputStream gzip = new GZIPOutputStream(bos);
OutputStreamWriter osw = new OutputStreamWriter(gzip, StandardCharsets.UTF_8);
osw.write(myDataInJsonStringFormat);
osw.close();

compressedJsonData = bos.toByteArray();