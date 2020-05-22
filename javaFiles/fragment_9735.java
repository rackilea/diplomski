public int[] moveUp(int[] selectedIndices) {
    int[] newIndices = Arrays.copyOf(selectedIndices, selectedIndices.length);

    IntStream.range(0, selectedIndices.length)
            .filter(i -> selectedIndices[i] != i)
            .forEach(i -> {
                swap(actions, selectedIndices[i], selectedIndices[i] - 1);
                newIndices[i]--;
            });

    return newIndices;
}