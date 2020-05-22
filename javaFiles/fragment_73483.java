public static List<Foo> buildFoosRecursive(String[] values) {
    ArrayList<Foo> list = new ArrayList<Foo>(values.length);
    buildFoosRecursive(values, 0, list);
    return list;
}

private static void buildFoosRecursive(String[] values, int index, List<Foo> fooList) {
    if (index >= values.length)
        return;

    List<Bar> bar1List = new ArrayList<Bar>(1);
    Foo newFoo = new Foo(values[index], bar1List);
    fooList.add(newFoo);

    buildFoosRecursive(values, index + 1, fooList);

    Bar bar1;
    if (fooList.size() > index + 1)
        bar1 = new Bar(fooList.get(index + 1));
    else
        bar1 = new Bar(null);

    bar1List.add(bar1);

    return;
}