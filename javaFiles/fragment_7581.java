Set<T> randomSubset(int size) {
    Set<T> set = new HashSet<>();
    while(set.size() < size) {
        T randomItem = randomItem();
            remove(randomItem); // removes the item from the distribution
            set.add(randomItem);
    }
    return set;
}