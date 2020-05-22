File file = new File("Hello.txt");
try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
    pw.println("HelloWorld"); // should have a new line
}

try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    for (String line; (line = br.readLine()) != null; ) {
        System.out.println(line);
    }
}