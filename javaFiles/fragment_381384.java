@Test
public void testArrays() {
    Set<String[]> set = new HashSet<String[]>();
    set.add(new String[] { "12.3f", "33.4f" });
    Assert.assertFalse(set.add(new String[] { "12.3f", "33.4f" }));
}