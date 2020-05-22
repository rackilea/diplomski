public static void main(String... args) throws FileNotFoundException {
    PrintWriter pw = new PrintWriter("Exercise_19.txt");
    for (int i = 0; i <= 200; i++)
        pw.println(i);
    pw.close();
}