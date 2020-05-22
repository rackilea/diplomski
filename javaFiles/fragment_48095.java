try (BufferedReader bReader = new BufferedReader(new FileReader(
        dataFileName))) {
    String line;
    int lineNumber = 0;
    while ((line = bReader.readLine()) != null) {
        lineNumber++;
        String datavalue[] = line.split("\t");
        String value2 = datavalue[1];
        String value14 = datavalue[13];

        if (!value2.equals("New Customer")) {
            System.err.printf("FAILURE: line: %d in column 2 is "
                    + "%s not 'New Customer'.%n", lineNumber, value2);
        }
        if (!(value14.equals("dog") || value14.equals("cat"))) {
            System.err.printf("FAILURE: line: %d in column 14 is "
                    + "%s not 'dog' or 'cat'.%n", lineNumber, value14);
        }
    }
} catch (Exception e) {
    e.printStackTrace();
}