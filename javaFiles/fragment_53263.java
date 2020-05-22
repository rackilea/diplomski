public static String inputString() {

    String stringOne;
    BufferedReader in;
    in = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter a string!");
    try {
        stringOne = in.readLine();
    } catch(IOException e) {

    }
    return stringOne;
}