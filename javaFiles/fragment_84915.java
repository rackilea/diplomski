public void testFindBiggestV3V4()
{
    UndirectedGraph<String, String> g = new UndirectedSparseGraph<>();
    createGraph(g);

    BronKerboschCliqueFinder2<String, String> finder = new BronKerboschCliqueFinder<>(g);

    Collection<String> initials = new ArrayList<>();
    initials.add(V3);
    initials.add(V4);

    Collection<Set<String>> cliques = finder.getAllMaximalCliques(initials);
    for (Set<String> clique : cliques) {
        System.out.println(clique);
    }
}