for (Entry<String, List<String>> item : vertices.entrySet()) {
    System.out.println("Vertex: " + item);
    for (String subitem : item.getValue()) {
        System.out.println(subitem);
    }
}