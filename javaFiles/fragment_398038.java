ListIterator<MyClass> fwd = classes.listIterator(idx);
ListIterator<MyClass> bck = classes.listIterator(idx);
MyClass found = null;
while (fwd.hasNext() || bck.hasPrevious()) {
    if (fwd.hasNext()) {
        MyClass my = fwd.next();
        if (my.isValid()) {
            found = my;
            break;
        }
    }
    if (bck.hasPrevious()) {
        MyClass my = bck.previous();
        if (my.isValid()) {
            found = my;
            break;
        }
    }
}