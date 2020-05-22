Object[] examples1 = { 100, "foo",
    new Area(new Rectangle(10, 20)), new Area(new Rectangle(20, 20)) };
Object[] examples2 = { new Integer(100), new String("foo"),// enforce a!=b
   new Area(new Rectangle(10, 20)) };
for(Object a: examples1) {
    for(Object b: examples2) {
        System.out.printf("%30s %30s: %b%n", a, b, EqualsOperation.equals(a, b));
    }
}