Predicate<Pair<Node,Node>> nodesMatch = pair -> 
    pair.left().id() == pair.right().id();

parentList.forEach(p -> {
    childList
        .stream()
        .map(c -> new Pair<Node>( c, p))
        .filter(nodesMatch)
        .map( pair -> pair.left() )
        .<...continue working on stream...>
});