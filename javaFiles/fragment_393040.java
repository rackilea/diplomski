public static void main(String[] args) {
    for (Node node : Parser.parseFragment("<test><author name=\"Vlad\"><book name=\"SO\"/>" ,
            new Element(Tag.valueOf("p"), ""),
            "")) {
        print(node, 0);
    }
}

public static void print(Node node, int offset) {
    for (int i = 0; i < offset; i++) {
        System.out.print(" ");
    }
    System.out.print(node.nodeName());
    for (Attribute attribute: node.attributes()) {
        System.out.print(", ");
        System.out.print(attribute.getKey() + "=" + attribute.getValue());
    }
    System.out.println();
    for (Node child : node.childNodes()) {
        print(child, offset + 4);
    }
}