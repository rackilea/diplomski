@Test
public void testListsFloat() {
    List<List<Float[]>> outter = new ArrayList();

    List<Float[]> inner1 = new ArrayList();
    inner1.add(new Float[] { 12.3f, 33.4f });
    inner1.add(new Float[] { 12.2f, 33.2f });
    inner1.add(new Float[] { 12.3f, 33.4f });

    List<Float[]> inner2 = new ArrayList();
    inner2.add(new Float[] { 12.1f, 33.1f });
    inner2.add(new Float[] { 12.2f, 33.2f });
    inner2.add(new Float[] { 12.3f, 33.4f });

    outter.add(inner1);
    outter.add(inner2);

    outter = ProcessList(outter);
    for (List<Float[]> list : outter) {
        for (Float[] array : list) {
            System.out.println(Arrays.toString(array));
        }
    }
}