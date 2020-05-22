private void p1(Map<Integer, C> cs, Map<Integer, B> bs, Function<C, Set<Integer>> f, BiConsumer<C,B> cons) {
    for (C c : cs.values()) {
        for (Integer id : f.apply(c)) {
            if (bs.containsKey(id)) {
                cons.accept(c,bs.get(id));
            }
        }
    }
}