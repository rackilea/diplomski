Set<Triangle> triangles = new HashSet<Triangle>();
for (String line : file) {
    Triangle t = makeTriangle(line);
    triangles.add(t); // does nothing if an equal Triangle is already in the set
}
System.out.println("The distinct triangles are:");
for (Triangle t : triangles) {
    System.out.println(t);
}