Collections.sort(mPairs, new Comparator<Pair<Integer,String>>() {
    @Override
    public int compare(Pair<Integer,String> p1, Pair<Integer,String> p2) {
        return p1.getKey().compareTo(p2.getKey());
    }
});
for (Pair<Integer,String> p : mPairs) {
    System.out.println(p.getValue());
}