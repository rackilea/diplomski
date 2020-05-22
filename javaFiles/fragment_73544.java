import com.google.protobuf.ByteString;
import com.google.protobuf.TextFormat;

String imgStr = "GIF89ax\000\364\001\367\000\000\000\000\000\001\001\001\002\002\002\003\003\003\004\004\004\005\005\005\006\006\006\a\a\a\b\b\b\t\t\t\n\n\n\v\v\v\f\f\f\r\r\ ..."; // must an full image string
ByteString unescapeBytes = TextFormat.unescapeBytes(imgStr);
byte[] bytes = new byte[unescapeBytes.size()];
unescapeBytes.copyTo(bytes, 0);

final BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream("result.gif"));
bw.write(bytes);
bw.close();