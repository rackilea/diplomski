public Matrix floyd() {
  Matrix m = new Matrix(numVertices, numVertices, Integer.MAX_VALUE);
  for (int i = 1; i<=numVertices; i++) {
    EdgeNode edge = edges[i];
    while (edge != null) {
      m.setData(i, edge.getY(), edge.getWeight());
      edge = edge.getNext();
    }
    m.setData(i, i, 0);
  }
  for (int i = 1; i <= numVertices; i++) {
    for (int j = 1; j <= numVertices; j++) {
      for (int k = 1; k <= numVertices; k++) {
        if (m.getData(i, j) < Integer.MAX_VALUE && m.getData(i, k) < Integer.MAX_VALUE) {
          int through = m.getData(i, j) + m.getData(i, k);
          if (through < m.getData(j, k)) {
            m.setData(j, k, through);
          }
        }
      }
    }
  }
  return m;
}