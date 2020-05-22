public static void g_txt() {
    String[] text_array = new String[5];
    int nu = 0;
    try {
        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            text_array[nu] = line;
            nu++;
            if (nu == 5) {
                nu = 0;
                makeObject(text_array);
            }
        }
    } catch (IOException e) {
    }

}

private static void makeObject(String[] text_array) {
    // do your object creation here
    System.out.println("_________________________________________________");
    for (String string : text_array) {
        System.out.println(string);
    }
    System.out.println("_________________________________________________");
}