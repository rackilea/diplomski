@Test
public void testFindFooByName() {
    String name = "foobar";
    String otherParam = "otherParam";

    String expectedHql = "SELECT f FROM Foo f WHERE 1 = 1 AND f.name = :name AND f.other = :otherParam";

    List<Foo> stubData = stubData();

    Mockito.when(mockQuery.getResultList()).thenReturn(stubData);
    Mockito.when(entityManager.createQuery(Mockito.eq(expectedHql), Mockito.eq(Foo.class))).thenReturn(mockQuery);

    List<Foo> actual = dao.findFooByName(name, otherParam);

    Assert.assertSame(stubData, actual);

    Mockito.verify(mockQuery).setParameter("name", name);
    Mockito.verify(mockQuery).setParameter("otherParam", otherParam);
}