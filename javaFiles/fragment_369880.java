public class BTest {

    @Test
    public void test () {
        B b = ( ... )
        Set<String> expectIds = new HashSet<>(Arrays.asList("id1","id2","id3"));
        Collection<A> collection = b.getCollection();
        Set<String> ids = collection.stream().map(a->a.getId()).collect(Collectors.toSet());

        assertEquals(3, collection.size());
        assertEquals(expectIds, ids);

    }

}