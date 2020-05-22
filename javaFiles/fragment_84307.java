private static DepthFirstTraversal graph;

@BeforeAll
public static void setUpGraph() {
    graph = new DepthFirstTraversal();
    graph.add(1); //add node
    graph.add(0);
    graph.add(2);
    graph.add(3);
    graph.add(4);
    graph.add(0,1); //connect nodes with edges
    graph.add(1,2);
    graph.add(2,3);
    graph.add(0,4);
}

@Test
void testCase1(){
    List<Integer> result = graph.traverse();
    List<Integer> expected = Arrays.asList(0,1,4,2,3);

    assertEquals(expected, result);
}