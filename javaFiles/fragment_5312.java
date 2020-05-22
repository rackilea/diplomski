public static String readFile(String filename) throws FileNotFoundException {
    Scanner sc = new Scanner(new File(filename));

    StringBuilder sb = new StringBuilder();
    while (sc.hasNextLine())
        sb.append(sc.nextLine());
    sc.close();

    return sb.toString();
}