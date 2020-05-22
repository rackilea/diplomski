class Row {
    String name;
    String parent;
    Row (String parent,String name,String something) {
        this.parent = parent;
        this.name = name;
    }
    public String getParent () {return parent;}
    public String getName () {return name;}

    public int hashCode () {return name.hashCode ();}
    public boolean equals (Object other) {
        return ((Row) other).name.equals (name);
    }
    public String toString ()
    {
        return name;
    }

    public static void main (String[] args)
    {
        List<Row> list = new ArrayList<>();
        list.add(new Row(null, "-", "Root"));
        list.add(new Row("-", "A", "Root"));
        list.add(new Row("A", "A1", "Alpha 1"));
        list.add(new Row("A1", "A11", "Alpha 11"));
        list.add(new Row("A", "A2", "Alpha 2"));
        list.add(new Row("-", "B", "Root"));
        list.add(new Row("B", "B1", "Bravo 1"));
        list.add(new Row("B", "B2", "Bravo 2"));
        Map<String,Row> nodes = 
            list.stream()
                .collect(Collectors.toMap(Row::getName,Function.identity()));
        Map<Row,List<Row>> tree = 
            list.stream()
                .filter(r->r.getParent()!= null)
                .collect(Collectors.groupingBy(r->nodes.get(r.getParent())));
        System.out.println (tree);
        Row root = nodes.get ("-");
        while (root != null) {
            System.out.print (root + " -> ");
            List<Row> children = tree.get (root);
            if (children != null && !children.isEmpty ()) {
                root = children.get (0);
            } else {
                root = null;
            }
        }
        System.out.println ();
    }
}