@Test
public void testParseRecurringDetailResulte() throws IOException {

    InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("ID41901838.json");

    ObjectReader objectReader = mapper.readerFor(RecurringDetailsResult.class);
    RecurringDetailsResult result = objectReader.readValue(inputStream);

    if (result.getDetails() != null && !result.getDetails().isEmpty()) {
        RecurringDetailWrapper detail = result.getDetails().get(0);
        if (StringUtils.isEmpty(detail.getRecurringDetail().getRecurringDetailReference())) {
            fail("Recurring detail does not contain any information.");
        }
    } else {
        fail("No result details returned.");
    }
}