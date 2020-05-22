public static void main(String[] args) throws IOException {

    String fileName = "test.txt";

    List<String> lines = new ArrayList<String>();

    // read the file into lines
    BufferedReader r = new BufferedReader(new FileReader(fileName));
    String in;
    while ((in = r.readLine()) != null)
        lines.add(in);
    r.close();

    // check your condition
    String secondFromBottom = lines.get(lines.size() - 2);
    if (secondFromBottom.matches("Hello World!")) {
        lines.remove(lines.size() - 1);
        lines.add("My fixed string");
    }  

    // write it back
    PrintWriter w = new PrintWriter(new FileWriter(fileName));
    for (String line : lines)
        w.println(line);
    w.close();
}