@RunWith(MockitoJUnitRunner.class)
public class TestExample {

    @Test
    public void testMyMethod() {
        Aggregations aggs = Mockito.mock(Aggregations.class);
        Cardinality cardinality = Mockito.mock(Cardinality.class);
        Map<String, Aggregation> map = new HashMap<String, Aggregation>();
        map.put("sample", cardinality);

        Mockito.doReturn(map).when(aggs).getAsMap();
        Assert.assertEquals(map, aggs.getAsMap());
    }
}