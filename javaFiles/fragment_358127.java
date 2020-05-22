Console cons = System.console();
if (cons != null) {
    String line = cons.readLine();
    System.out.println(line);
} else {
    System.out.println("no console");
}