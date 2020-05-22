@Test
@DatabaseSetup(value = "InitialDataset.xml")
@ExpectedDatabase(value = "ExpectedDataset.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
public void test() throws IOException, UnhandledRequestException {
    ...
}