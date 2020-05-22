// We don't know what the Foo type is...
for (Iterator<Foo> iterator = array.iterator(); iterator.hasNext(); ) {
    Foo element = iterator.next();
    if (element.getParent().equals(parent)) {
        iterator.remove(); // Note: *not* array.remove(...)
    }
}