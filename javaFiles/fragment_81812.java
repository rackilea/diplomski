@Test
public void removeDups() {
    List<MyObject> list = Arrays.asList(new MyObject(0, 0), new MyObject(0, 0), new MyObject(0.5, 0.5), new MyObject(0.5, 0.6), new MyObject(1, 1));
    List<MyObject> results = Arrays.asList(new MyObject(0, 0), new MyObject(0.5, 0.5), new MyObject(0.5, 0.6), new MyObject(1, 1));
    assertEquals(results, unique(list));
}