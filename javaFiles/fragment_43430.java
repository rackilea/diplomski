@Before
public void setup() {
    file = new CSVFile();
    file.setFileName("test_file");
    file.getValidRecords().add((ValidRecord) new Record(1, "USD", "AED", new Date(), 100.00, file).validate());
    file.getInvalidRecords().add((InvalidRecord) new Record(2, "USD", "USD", new Date(), 100.00, file).validate());
}