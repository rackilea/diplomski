public static void main(String[] args) throws Exception {
    String REGEX = "\\(s\\)|s$";

    System.out.println("Packs".replaceAll(REGEX, "")
                              .toLowerCase());
    System.out.println("packs".replaceAll(REGEX, "")
                              .toLowerCase());
    System.out.println("Pack(s)".replaceAll(REGEX, "")
                                .toLowerCase());
    System.out.println("pack(s)".replaceAll(REGEX, "")
                                .toLowerCase());
    System.out.println("pack".replaceAll(REGEX, "")
                             .toLowerCase());
}