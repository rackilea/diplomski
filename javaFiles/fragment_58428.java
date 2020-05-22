Graph graph = GraphBuilder.newGraph()
                      .addVertex("A")
                      .edgeName("")
                      .addVertex("B", "b-fork")
                      .edgeName("")
                      .addVertex("C")
                      .edgeName("")
                      .addVertex("E")

                      .goBack(2) // even worse than using label: breaks easily
                      .edgeName("")    
                      .addVertex("D")
                      .edgeName("")
                      .addVertex("F")
                      .build();