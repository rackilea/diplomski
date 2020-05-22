Iterator<ArrayList<Integer>> outer = chains.iterator ();
while (outer.hasNext ()) {
    ArrayList<Integer> outerChain = outer.next();
    Iterator<ArrayList<Integer>> inner = chains.iterator ();
    while (inner.hasNext ()) {
        ArrayList<Integer> innerChain = inner.next();
        if (outerChain.get(0).equals(innerChain.get(innerChain.size() - 1))) {
            outerChain.remove(0);
            innerChain.addAll(outerChain);
            outer.remove();
            break;
        }
    }
}