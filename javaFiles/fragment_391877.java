public static int ThreeCharacters(String s2) throws IOException {

    Scanner in = new Scanner(new File(s2));
    int count = 0;

    while (in.hasNextLine()) {
        in.nextLine();
        if (in.nextLine().length() == 3) {
            count++;
        }
    }

    in.close();
    return count;
}