public class BTest {

    @Test
    public void test () {
        B b = ( ... )
        Collection<A> collection = b.getCollection();

        assertEquals(3, collection.size());
        assertThat(collection).extracting("id").contains("id1","id2","id3");
    }
}