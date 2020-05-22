final LinkedList<Foo> worklist = new LinkedList<>();
worklist.add(new Foo());
ListIterator<Foo> iterator = worklist.listIterator();
while (iterator.hasNext()) {
    Foo foo = iterator.next();
    iterator.add(new Foo());
}