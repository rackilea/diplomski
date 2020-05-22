private static abstract class AbstractClass<T> {

    final List<T> objects = new ArrayList<T>();
}

private static class ComponentHolder extends AbstractClass<Component> {

    public void add(final Component c) {
        objects.add(c);
    }

    public Component getComponent(final int index) {
        return objects.get(index);
    }
}