@Override
public Spliterator<String> trySplit() {
    if(limit - position <= 1)
        return null;
    long newPosition = (position+limit)>>>1;
    Spliterator<String> prefix = 
             new MySpliterator(position, newPosition, currentPermutation);
    this.position = newPosition;
    this.currentPermutation = null;
    return prefix;
}

@Override
public boolean tryAdvance(Consumer<? super String> action) {
    if(currentPermutation == null)
        currentPermutation = calculatePermutation(position); // hard part
    ...
}