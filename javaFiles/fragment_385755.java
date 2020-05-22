public void test() {
    // Start data.
    Map<String, A> asInAMap = new HashMap<>();
    // The B's arrive.
    List<B> arrivingBs = new ArrayList<>();
    // Grab the A's and key them on colour.
    Map<Colour, A> asInColour = new HashMap<>();
    // Keep track of all As.
    Set<A> availableAs = new HashSet<>(asInAMap.values());
    // Roll them into the Map.
    for (A a : availableAs) {
        // Key all A's by colour.
        asInColour.put(a.colour, a);
    }
    // Walk the Bs, matching up the A's
    Set<A> matchedAs = new HashSet<>();
    Set<B> unMatchedBs = new HashSet<>();
    for (B b : arrivingBs) {
        // Is there a matching A with the right colour?
        A aMatched = asInColour.get(b.colour);
        if (aMatched != null) {
            // Keep track of the ones that matched.
            matchedAs.add(aMatched);
        } else {
            // Keep track of all not-matched Bs.
            unMatchedBs.add(b);
        }
    }
    // Don't touch any of the matched ones.
    availableAs.removeAll(matchedAs);
    // Change colours of any A.s left.
    Iterator<B> bsWithNewColours = unMatchedBs.iterator();
    for (A changeAColour : availableAs) {
        if (bsWithNewColours.hasNext()) {
            B newB = bsWithNewColours.next();
            // Change a spare A's colour.
            changeAColour.colour = newB.colour;
            // Finished with that one.
            bsWithNewColours.remove();
        }
    }
    // All that are left in notMatched must generate new A's.
    for (B newColour : unMatchedBs) {
        // Make a new A with a non-matched colour.
        asInAMap.put(String.valueOf(newColour.colour), new A(newColour.colour));
    }
}