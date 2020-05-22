Element td = getItSomehow();

for (Node child : td.childNodes()) {
    if (child instanceof TextNode) {
        System.out.println(((TextNode) child).text());
    }
}