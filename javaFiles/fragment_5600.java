public static <T> T getItem(Element element, Class<T> clazz) {
    IParsable item = null;
    if (clazz == IFoo.class) {
        item = new Foo();
    } else if (clazz == IBar.class) {
        item = new Bar();
    }
    item.parse();
    return (T) item;
}