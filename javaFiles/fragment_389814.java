Properties p = new Properties();
try (Reader reader = new FileReader(filePath)) {
    // Load the file
    p.load(reader);
}
// Print the value of the parameter test2
System.out.println(p.getProperty("test2"));