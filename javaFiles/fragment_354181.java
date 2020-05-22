package alehro.droid;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;

import alehro.log.Logger;
import alehro.tcp.ChunkFileResourceThrift;
import alehro.tcp.ServerSideError;

class ThriftClientExt extends ChunkFileResourceThrift.Client {
public ThriftClientExt(TProtocol prot) {
    super(prot);

}

public void recv_get_file_ext(String get_file_out_path) throws TException,
        IOException, ServerSideError {
    FileOutputStream fos = new FileOutputStream(get_file_out_path);
    FileChannel channel = fos.getChannel();
    int size = 0;
    // -1 - end of file, -2 exception.
    while ((size = iprot_.readI32()) > 0) {
        Logger.me.v("receiving buffer size=" + size);
        ByteBuffer out = iprot_.readBinary();
        // out.flip();
        channel.write(out);
    }
    if (size == -2) {
        String msg = iprot_.readString();
        Logger.me.e("Server error: " + msg);
        // TODO: report error to user
    }
    channel.close();
    recv_get_file();
}

}