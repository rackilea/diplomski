/** See http://wiki.vg/Protocol_version_numbers.  47 = 1.8.x */
private static final int PROTOCOL_VERSION_NUMBER = 47;
private static final int STATUS_PROTOCOL = 1;
private static final JsonParser PARSER = new JsonParser();

/** Pings a server, returning the MOTD */
public static String pingServer(String host, int port) {
    this.host = host;
    this.port = port;

    try {
        socket.connect(new InetSocketAddress(host, port));
        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();

        byte[] hostBytes = host.getBytes("UTF-8");
        int handshakeLength =
                varIntLength(0) + // Packet ID
                varIntLength(PROTOCOL_VERSION_NUMBER) + // Protocol version number
                varIntLength(hostBytes.length) + hostBytes.length + // Host
                2 + // Port
                varIntLength(STATUS_PROTOCOL);  // Next state

        writeVarInt(handshakeLength, out);
        writeVarInt(0, out);  // Handshake packet
        writeVarInt(PROTOCOL_VERSION_NUMBER, out);
        writeVarInt(hostBytes.length, out);
        out.write(hostBytes);
        out.write((port & 0xFF00) >> 8);
        out.write(port & 0xFF);
        writeVarInt(STATUS_PROTOCOL, out);

        writeVarInt(varIntLength(0));
        writeVarInt(0);  // Request packet (has no payload)

        int packetLength = readVarInt(in);
        int payloadLength = readVarInt(in);
        byte[] payloadBytes = new int[payloadLength];
        int readLength = in.read(payloadBytes);
        if (readLength < payloadLength) {
            throw new RuntimeException("Unexpected end of stream");
        }
        String payload = new String(payloadBytes, "UTF-8");

        // Now you need to parse the JSON; this is using GSON
        // See https://github.com/google/gson
        // and http://www.javadoc.io/doc/com.google.code.gson/gson/2.8.0
        JsonObject element = (JsonObject) PARSER.parse(payload);
        JsonElement description = element.get("description");
        // This is a naive implementation; it assumes a specific format for the description
        // rather than parsing the entire chat format.  But it works for the way the
        // notchian server impmlements the ping.
        String motd = ((JsonObject) description).get("text").getAsString();

        return motd;
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }
}

public static int varIntLength(int value) {
    int length = 0;
    do {
        // Note: >>> means that the sign bit is shifted with the rest of the number rather than being left alone
        value >>>= 7;
        length++;
    } while (value != 0);
}

public static void writeVarInt(int value, OutputStream out) {
    do {
        byte temp = (byte)(value & 0b01111111);
        // Note: >>> means that the sign bit is shifted with the rest of the number rather than being left alone
        value >>>= 7;
        if (value != 0) {
            temp |= 0b10000000;
        }
        out.write(temp);
    } while (value != 0);
}
public static int readVarInt(InputStream in) {
    int numRead = 0;
    int result = 0;
    int read;
    do {
        read = in.read();
        if (read < 0) {
            throw new RuntimeException("Unexpected end of stream");
        }
        int value = (read & 0b01111111);
        result |= (value << (7 * numRead));

        numRead++;
        if (numRead > 5) {
            throw new RuntimeException("VarInt is too big");
        }
    } while ((read & 0b10000000) != 0);

    return result;
}