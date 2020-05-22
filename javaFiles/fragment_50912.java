while (res.hasNext()) {
    Map<String, Object> row = res.next();
    Node n = (Node) row.get("u");
    if (row.get("g") != null) { //that was causing the NullPointerException
        Node g = (Node) row.get("g");
        System.out.println(n.getAllProperties() + ": " + g.getAllProperties());
    } else System.out.println(n.getAllProperties());
}