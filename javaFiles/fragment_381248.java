private void countCollisions() throws Exception {
    final String letters1 = "abcdefgh";
    final String letters2 = "ABCDEFGH";
    final int total = letters1.length() * letters2.length();
    for (final HashCodeMethod hcm : HashCodeMethod.values()) {
        final Multiset<Integer> histogram = HashMultiset.create();
        for (final String s1 : Splitter.fixedLength(1).split(letters1)) {
            for (final String s2 : Splitter.fixedLength(1).split(letters2)) {
                histogram.add(hcm.hashCode(ImmutableMultiset.of(s1, s2, s2)));
            }
        }
        System.out.println("Collisions " + hcm + ": " + (total-histogram.elementSet().size()));
    }
}