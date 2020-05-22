private <T,U> Predicate<U> curry(BiPredicate<T,U> biPredicate, T t) {
    return u -> biPredicate.test(t, u);
} 

BiPredicate<Node,Node> nodesMatch = (a,b) -> a.id() == b.id();

parentList.forEach(p -> {
    childList
        .stream()
        .filter(curry(nodesMatch, p))
        .<...continue working on stream...>
});