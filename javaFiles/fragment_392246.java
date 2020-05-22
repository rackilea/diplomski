@Test
public void testFindFooByName() {
    List<Foo> stubData = stubData();

    Mockito.when(entityManager.createQuery(Mockito.anyString(), Mockito.eq(Foo.class))).thenReturn(mockQuery);

    dao.findFooByName("foobar", null);

    Mockito.verify(mockQuery).getResultList();
}