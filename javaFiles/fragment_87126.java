final LinkedList<Foo> worklist = new LinkedList<>();
worklist.add(new Foo());
Iterator<Foo> iterator = worklist.iterator();
while (iterator.hasNext()) {
    Foo foo = iterator.next();
    worklist.add(new Foo());
}