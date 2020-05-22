Function<B, A> BtoA = new Function<B, A>() {
    public A apply(final B b) {
        return b.getA();
    }
};
Function<A, String> aToId = new Function<A, String>() {
    public String apply(final A a) {
        return a.getId();
    }
};

java.util.Collection<B> bToDelete = Collections2.filter(currentB, Predicates.compose(Predicates.not(Predicates.in(newA)), BtoA));

//without transform, looks ugly
java.util.Collection<A> aToAdd = Collections2.filter(newA, new Predicate<A>() {
    @Override
    public boolean apply(final A a) {
        return !Iterables.any(currentB, new Predicate<B>() {
            @Override
            public boolean apply(B b) {
                return b.getA().equals(a);
            }
        });
    }
});
// this is essentially the same, you can safely use transform
//java.util.Collection<A> aToAdd = Collections2.filter(newA, Predicates.not(Predicates.in(Collections2.transform(currentB, BtoA))));

java.util.Collection<String> idToDelete = Collections2.transform(bToDelete, Functions.compose(aToId, BtoA));
java.util.Collection<String> idToAdd = Collections2.transform(aToAdd, aToId);

System.out.println("Old B: " + idToDelete);
System.out.println("New A: " + idToAdd);