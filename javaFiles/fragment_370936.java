public boolean duplicateVenueSessions() {
    Set<Pair<String, Integer>> distinct = new HashSet<>();
    for (Event e : this.events) {
        Pair<String, Integer> venueSession = new Pair<>(e.venue, e.session);
        if (distinct.contains(venueSession)) {
            return true;
        }
        distinct.add(venueSession);
    }
    return false;
}