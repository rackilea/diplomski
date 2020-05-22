CSVFormat csvFormat = CSVFormat.RFC4180
        .withFirstRecordAsHeader()
        .withIgnoreHeaderCase()
        .withTrim();

String fileName = "C:\\Users\\prassuha\\JavaProjects\\gs-maven-master\\complete\\src\\main\\java\\hello\\customer.csv";
String input = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
String[] sections = input.split("(?m)^[,\\s]*\\R");

List<Person> persons = new ArrayList<>();
try (CSVParser csvParser = new CSVParser(new StringReader(sections[0]), csvFormat)) {
    for (CSVRecord csvRecord : csvParser) {
        String id_number = csvRecord.get("id_number");
        if (id_number.isEmpty())
            break; // end of person part of CSV data
        persons.add(new Person(
                id_number,
                csvRecord.get("last_name"),
                csvRecord.get("first_name")));
    }
}

List<Business> businesses = new ArrayList<>();
try (CSVParser csvParser = new CSVParser(new StringReader(sections[1]), csvFormat)) {
    for (CSVRecord csvRecord : csvParser) {
        String id_number = csvRecord.get("id_number");
        if (id_number.isEmpty())
            break; // end of business part of CSV data
        businesses.add(new Business(
                id_number,
                csvRecord.get("business_name")));
    }
}