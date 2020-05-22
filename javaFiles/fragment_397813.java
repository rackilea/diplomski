@Test public void testGetPeopleSortsByPeopleName() {

    peopleStuff.data = buildMockDataSource(COUNTRY, "A", "D", "B", "C")

    List<String> result = peopleStuff.getSortedPeopleForCountry(COUNTRY);

    assertPersonList(result, "A", "B", "C", "D")
}

private IData buildMockDataSource(String country, String ... names) {
    ...
}

private void assertPersonList(List<Person> people, String ... names) {
    ...
}