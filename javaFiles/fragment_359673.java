@Test
public void shouldAddValue() {
    Set<String> mySet = new HashSet<String>();
    mySet.put("test_value");

    // Mock container getValues() method to return mySet
    when(container.getValues()).thenReturn(mySet); // do import static for Mockito.when

    assertTrue(container.getValues().contains("test_value"));
}