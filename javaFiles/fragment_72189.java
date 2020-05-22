public int compareTo(BaseLink<?> link) {
    int res = this.priority.compareTo(link.getPriority());
    if (res == 0) {
        // tie-breaker for different links with the same priority
        res = // compare using some other key / identifier
    }
    return res;
}