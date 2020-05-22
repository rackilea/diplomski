for(int i = 0; i < N; i++){
    vertices.add(new Vertex(i + 1, junctions.get(i)); 
}

for(int i = 0; i < N - 1; i++){
    //Initialize x, y, x1, y1 here, I just skipped it
    Vertex vertex1 = vertices.get(paths.getX() - 1);
    Vertex vertex2 = vertices.get(paths.getY() - 1);

    double distance = Math.sqrt(Math.pow(x - x1, 2) + Math.pow(y - y1, 2));

    vertex1.addNeighbour(new Edge(distance, vertex2));


}