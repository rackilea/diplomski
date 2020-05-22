import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import org.apache.commons.io.FileUtils;

public class ZeroCopyServer {

public static void main(String[] args) throws IOException {

    final File outputFile = new File(args[0]);

    ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
    serverSocketChannel.socket().bind(new InetSocketAddress(8083));     
    SocketChannel socketChannel = serverSocketChannel.accept();

    //read input file length and CRC32 checksum sent by client
    ByteBuffer request = ByteBuffer.allocate(16);
    socketChannel.read(request);
    request.flip();
    long length = request.getLong();
    long checksumCRC32 = request.getLong();

    FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
    FileChannel fileChannel = fileOutputStream.getChannel();
    long totalBytesTransferFrom = 0;
    while (totalBytesTransferFrom < length) {
        long transferFromByteCount = fileChannel.transferFrom(socketChannel, totalBytesTransferFrom, length-totalBytesTransferFrom);
        if (transferFromByteCount <= 0){
            break;
        }
        totalBytesTransferFrom += transferFromByteCount;
    }

    long outChecksumCRC32 = FileUtils.checksumCRC32(outputFile);

    //write output file length and CRC32 checksum back to client
    ByteBuffer response = ByteBuffer.allocate(16);
    response.putLong(totalBytesTransferFrom);
    response.putLong(outChecksumCRC32);
    response.flip();
    socketChannel.write(response);

    serverSocketChannel.close();

    System.out.println("CRC32 equal= " + (checksumCRC32 == outChecksumCRC32));

  }
}