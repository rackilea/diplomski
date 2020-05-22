Foo f;

f = new Foo(); // The first Foo
f.setName("Bar");

while (/* some condition */) {
    // Periodically create new ones
    f = f.spawn();
}