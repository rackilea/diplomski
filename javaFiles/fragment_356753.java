@Test
  public void mapVertexToLazyObjectWithSameMapperOnMultipleThreadsAtTheSameTime()  {
    StackVertex vertex = new StackVertex(graph, 1L, "test", Optional.empty());
    mockVertex(vertex, NO_EDGES, NO_EDGES, properties("name", "foobar"));

    VertexEntityMapper<NamedNode> mapper = objectMapper.getMapper(NamedNode.class);
    NamedNode obj = mapper.mapToObject(vertex);

    final Boolean[] flags = { false, false };
    Runnable run = () -> {
      if ( obj.getName() == null || !obj.getName().equals("foobar") ) {
        flags[0]  = true;
      }
    };

    List<Thread> threads = IntStream.range(0, 10).boxed()
      .map(i -> new Thread(run)).collect(toList());
    threads.forEach(Thread::start);
    threads.forEach((thread) -> {
      try { thread.join(); } catch (InterruptedException e) {
        flags[1] = true;
      }
    });

    verify(vertexRepository, times(1)).findById(graph.tx(), 1L, Optional.empty());
    assertFalse("race condition",     flags[0]);
    assertFalse("thread interrupted", flags[1]);
  }