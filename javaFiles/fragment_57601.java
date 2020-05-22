String input = "value1, \"value2\", \"value3, 1234\", \"value4\n"
            + "value5\n"
            + "value6\"";

    try (CSVReader reader = new CSVReader(new StringReader(input))) {
        String [] tokens;
        while ((tokens = reader.readNext()) != null) {
            System.out.println(Arrays.toString(tokens));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }