public boolean duplicateVenueSessions() {
    // Map each Event to a Pair<Venue, Integer> and remove the duplicates
    long numDistinct = this.events.stream()
                                  .map(e -> new Pair<>(e.venue, e.session))
                                  .distinct()
                                  .count();
    // return false if the original number of events is different from the
    // number of distinct events considering only venue and session values
    return this.events.size() != numDistinct;
}