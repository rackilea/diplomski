neighboursOfCurrentVertexList.stream()
        .filter(vertex -> !vertex.isMarked())
        .forEach(vertex -> {
            vertex.setMarked(true);
            queueToVisitVertex.add(vertex);
        });