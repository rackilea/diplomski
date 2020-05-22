class A { int id; String foo; }
class B { int id; String bar; }

List<A> listA = ...
List<B> listB = ...
Map<Integer, B> mapB = listB.stream().collect(Collectors.toMap(b -> b.id, b -> b));
for (A a : listA) {
    B b = mapB.get(a.id);
    a.foo = b.bar;
}