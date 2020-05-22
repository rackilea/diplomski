public static int getTotal(List<Candidate> candidates) {
    int total = 0;
    foreach (Candidate c : candidates) {
        total += c.getVotes();
    }
    return total;
}