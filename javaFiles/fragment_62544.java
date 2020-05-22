public static void main(String[] args) throws IOException {
    InputStream stream = new FileInputStream("cube_mapping2.txt");
    Scanner s = new Scanner(stream);
    List<Byte> bytes = new ArrayList<Byte>();
    while (s.hasNextByte()) {
        bytes.add(s.nextByte());
    }
    System.out.println(bytes);
}