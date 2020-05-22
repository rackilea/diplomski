private void mapAtoB(List<A> aList, SetMultimap<String, B> mmap) {
    for (A a : aList) {
        Collection<B> possible = null;
        for (int i = 0; i < a.getFirstName().length() - NGRAM_LENGTH + 1; i++) {
            String ngram = a.getFirstName().substring(i, i + NGRAM_LENGTH);
            Set<B> forNgram = mmap.get(ngram);
            if (possible == null) {
                possible = new ArrayList<>(forNgram);
            } else {
                possible.retainAll(forNgram);
            }
            if (possible.size() < 20) { // it's ok to scan through 20
                break;
            }
        }
        for (B b : possible) {
            if (b.equalsB(a)) {
                b.setId(a.getRedirectId());
            }
        }
    }
}