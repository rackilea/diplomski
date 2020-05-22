@Test
// http://opensource.atlassian.com/projects/hibernate/browse/HHH-5159
public void testQueryWithInElementOfCollectionOfElementsOfEnums() {
    Person person = new Person("Bruce", "Wayne");
    Set<SomeEnum> someEnums = new HashSet<SomeEnum>();
    someEnums.add(SomeEnum.ONE);
    someEnums.add(SomeEnum.TWO);
    someEnums.add(SomeEnum.FIVE);

    person.setSomeEnums(someEnums);

    session.persist(person);

    String queryString = "SELECT p FROM Person p WHERE :someEnum in elements(p.someEnums)";

    Query query = session.createQuery(queryString);
    // query.setParameter("someEnum", SomeEnum.FIVE); // doesn't work, see HHH-5159
    query.setParameter("someEnum", SomeEnum.FIVE.name());
    List actual = query.list();
    assertNotNull(actual);
    assertEquals(1, actual.size());
}