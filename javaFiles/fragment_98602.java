public void removeEvenElems() {
    current = 1;
    for (int i = 0; i < size; i++) {
        nodes[i] = nodes[current];
        size--;
        current = current + 2;
    }
}