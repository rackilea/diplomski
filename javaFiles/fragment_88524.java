@Test
public void testFindByTitleLike() {
    String title = "Matrix";
    Collection<Movie> result = instance.findByTitleLike("*"+title+"*");
    assertNotNull(result);
    assertEquals(1, result.size());
}