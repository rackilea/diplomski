StringBuilder dziennik = new StringBuilder();
double total = 0; // Added line
double counter = 0; // Added line
try (BufferedReader br = Files.newBufferedReader(Paths.get("dziennik.txt"))) {
    // read line by line
    String line;
    while ((line = br.readLine()) != null) {
        dziennik.append(line).append("\n");
        String[] pair = line.split(" ");
        total = total + Double.valueOf(pair[2]); // Added line
        counter++; // Added line
    }
    System.out.println("Average number of notes per student: " + total / counter); // Added line
} catch (IOException e) {
    System.err.format("IOException: %s%n", e);
}
System.out.println(dziennik);