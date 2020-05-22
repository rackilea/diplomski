for (int i = 0; i < triangleStripVertices.size() - 2; i++) {
    if (i % 2) {
        triangleVertices.add(triangleStripVertices.get(i + 1));
        triangleVertices.add(triangleStripVertices.get(i));
        triangleVertices.add(triangleStripVertices.get(i + 2));         
    } 
    else {
        triangleVertices.add(triangleStripVertices.get(i));
        triangleVertices.add(triangleStripVertices.get(i + 1));
        triangleVertices.add(triangleStripVertices.get(i + 2));
    }
}