new PriorityQueue<String>((w1, w2) -> {
    if (count.get(w1).equals(count.get(w2))) { // If the counts of w1 and w2 are the same,
        return w2.compareTo(w1); // Then return the reverse lexicographical ordering of w1 and w2 (e.g. "Zebra" comes before "Apple")
    } else if (count.get(w1) < count.get(w2)) {
        return -1; // w1 comes before w2
    } else {
        return 1; // w1 comes after w2
    }
});