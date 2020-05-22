try (BufferedReader reader = Files.newBufferedReader(
        Paths.get(System.getProperty("user.home"),
            "projects", "app", "target", "resources",
            "external", "input", "external_file.txt")) {

    String test_line = reader.readLine();
    System.out.println( "First line: " + test_line ); 
}