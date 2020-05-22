public static void main(String[] args) throws Exception {
    byte[] serial = serial(Enum.A);
    Enum e = unserial(serial, Enum.class);

    System.out.println(e);
}