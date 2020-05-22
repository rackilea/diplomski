package net.openhft.chronicle.wire;

import net.openhft.chronicle.bytes.Bytes;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class WireToOutputStream {
    private final Bytes<ByteBuffer> bytes = Bytes.elasticHeapByteBuffer(128);
    private final Wire wire;
    private final DataOutputStream dos;

    public WireToOutputStream(WireType wireType, OutputStream os) {
        wire = wireType.apply(bytes);
        dos = new DataOutputStream(os);
    }

    public Wire getWire() {
        wire.clear();
        return wire;
    }

    public void flush() throws IOException {
        int length = Math.toIntExact(bytes.readRemaining());
        dos.writeInt(length);
        dos.write(bytes.underlyingObject().array(), 0, length);
    }
}

package net.openhft.chronicle.wire;

import net.openhft.chronicle.bytes.Bytes;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StreamCorruptedException;
import java.nio.ByteBuffer;

public class InputStreamToWire {
    private final Bytes<ByteBuffer> bytes = Bytes.elasticHeapByteBuffer(128);
    private final Wire wire;
    private final DataInputStream dis;

    public InputStreamToWire(WireType wireType, InputStream is) {
        wire = wireType.apply(bytes);
        dis = new DataInputStream(is);
    }

    public Wire readOne() throws IOException {
        wire.clear();
        int length = dis.readInt();
        if (length < 0) throw new StreamCorruptedException();
        bytes.ensureCapacity(length);
        byte[] array = bytes.underlyingObject().array();
        dis.readFully(array, 0, length);
        bytes.readPositionRemaining(0, length);
        return wire;
    }
}