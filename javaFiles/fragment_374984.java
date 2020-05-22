try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(
            App.class.getResourceAsStream("/input/external_file.txt"))) {

    String test_line = reader.readLine();
    System.out.println( "First line: " + test_line ); 
}