public int compareTo(ExpandedTerm conf) {
    int compare = new Double(this.confidence).compareTo(new Double(conf.confidence));

    if (compare == 0) {
        compare = new Double(this.support).compareTo(new Double(conf.support));
    }
    return compare;
}