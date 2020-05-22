DataInputStream input = new DataInputStream(ios);

byte type = input.readByte();
switch (type) {
case 3:
    return input.readLong();
}