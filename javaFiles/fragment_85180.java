private void foo(List<?> list) {
    Object o = list.get(0); // ok
    list.add(new Object()); // won't compile!

    // you cannot add anything, and only extract Object instances
}

private void foo(List<? extends TheClass> list) {
    Object o1 = list.get(0);   // ok
    TheClass o2 = list.get(0); // ok
    list.add(new Object());    // won't compile!
    list.add(new TheClass());  // won't compile!

    // You are sure that the objects are of a subtype of TheClass,
    // so you can extract TheClass instances safely. However, you cannot
    // add anything to this list since its type is not known (may be
    // different from TheClass, so the compiler does not allow anything).
}

private void foo(List<? super TheClass> list) {
    Object o1 = list.get(0);   // ok
    TheClass o2 = list.get(0); // won't compile!
    list.add(new Object());    // won't compile!
    list.add(new TheClass());  // ok

    // You are sure that the objects are of a type implemented by TheClass,
    // so you can add any TheClass instances to the list. However, you cannot
    // extract TheClass objects since the objects type may be just implemented
    // by TheClass, but different.
}