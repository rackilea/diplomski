public static void main(String[] args) throws IOException {
        String name = "...";
        DataOutputStream output = new DataOutputStream
                (new FileOutputStream(name));
        output.writeUTF("San Francisco: ");
        output.writeDouble(1123.456);
        output.close();
}

public static void main(String[] args) throws IOException {
    String name = "C:/Users/hsivakumar/Downloads/sales.dat";

    DataInputStream reader = new DataInputStream(new FileInputStream(name));

    StringBuilder builder = new StringBuilder();
    builder.append(reader.readUTF());
    builder.append(reader.readDouble());
    reader.close();
    System.out.println(builder);
}