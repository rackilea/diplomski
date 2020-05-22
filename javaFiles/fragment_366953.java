@Test
public void testMyMethod() {

    Cardinality cardinality = Mockito.mock(Cardinality.class);
    Mockito.when(cardinality.getName()).thenReturn("sample");

    List<Aggregation> list = new ArrayList<>();
    list.add(cardinality);

    Aggregations aggs = new Aggregations(list);
    Map<String, Aggregation> map = aggs.getAsMap();

    Assert.assertEquals(1, map.size());
    Assert.assertEquals(cardinality, map.get("sample"));
}