SimpleGraph<String, DefaultEdge> sg = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);
    sg.addVertex("A");
    sg.addVertex("B");
    sg.addVertex("C");
    sg.addEdge("A", "B");
    sg.addEdge("B", "C");
    System.out.println("graph: " + sg.toString());
    System.out.println("edges of A: " + sg.edgesOf("A"));
    System.out.println("edges of B: " + sg.edgesOf("B"));