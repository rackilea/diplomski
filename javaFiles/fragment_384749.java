List<Thing> list = . . .;
for (Iterator<Thing> iter = list.iterator(); iter.hasNext(); ) {
    Thing t = iter.next();
    if (!isValid(t)) {
        iter.remove(); // removal through the iterator itself is ok
    }
}