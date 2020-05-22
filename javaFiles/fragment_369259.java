// Subclass implements size and color, but superclass does not
if (foo instanceof Subclass) {
    Subclass foobar = (Subclass) foo;
    int size = foobar.size();
    String color = foobar.color();
}