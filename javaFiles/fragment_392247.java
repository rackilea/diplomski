@Test
public void testFindFooByName() {
    List<Foo> stubData = stubData();

    Mockito.when(mockQuery.getResultList()).thenReturn(stubData);
    Mockito.when(entityManager.createQuery(Mockito.anyString(), Mockito.eq(Foo.class))).thenReturn(mockQuery);

    List<Foo> actual = dao.findFooByName("foobar", null);

    Assert.assertSame(stubData, actual);
}