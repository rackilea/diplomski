class ListHolder<T extends Object> {
    List<T> list = new ArrayList<>();

    ListHolder() {
        list.add(new Object());
    }
}