DataInputStream stream;

// ...

int    length  = stream.readInt();
byte   id      = stream.readByte();
byte[] payload = new byte[length - 1];

stream.readFully(payload);