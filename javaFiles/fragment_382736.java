List<String[]> al = new ArrayList<>();
try (BufferedReader br = new BufferedReader(new FileReader(f))) {
    String line;
    while ((line = br.readLine()) != null) {
        al.add(line.split("\\s+"));
    }
} catch (IOException exception) {
    System.out.println("Exception: " + exception.getMessage());
    exception.printStackTrace();
}