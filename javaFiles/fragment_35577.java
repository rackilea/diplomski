private static void interleave(ArrayList<Integer> a1, ArrayList<Integer> a2) {
    ArrayList<Integer> r = new ArrayList<>(a1.size() + a2.size());

    for(int i = 0, j = 0; i < a1.size() || j < a2.size(); i++, j++) {
        if(i < a1.size()) r.add(a1.get(i));
        if(j < a2.size()) r.add(a2.get(j));
    }
    a1.clear();
    a1.addAll(r);
}