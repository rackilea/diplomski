try (BufferedReader reader = new BufferedReader(new FileReader("test.txt"))) {
    for (String line; (line = reader.readLine()) != null; ) {
        String[] tokens = line.split("\\s+");
        // use tokens array here
    }
}