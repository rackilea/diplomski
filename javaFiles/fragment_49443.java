final String DELIMITER = " "; // using space
String example = "one.xml two.xml three.xml";
List<String> items = Arrays.asList(example.split(DELIMITER));

for (String item : items) { // test output
    System.out.println(item);
}