public static void main(String[] args) throws IOException {
    int myCounter = 0;
    myCounter += 10;
    final File file = new File("/some/sensible/location");
    try (final DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
        dos.writeInt(myCounter);
    }
    try (final DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
        System.out.println("Reading int from file: " + dis.readInt());
    }
}