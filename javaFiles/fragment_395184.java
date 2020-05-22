Iterator<Integer> iterator = pp.iterator();
while(iterator.hasNext()) {
    Integer age = iterator.next();
    if (... your test here) {
        iterator.remove(); // This removes the age from the list AND takes care of updating it, so that the next next() call will work correctly
    }
}