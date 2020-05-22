public int[] moveUp(int[] selectedIndices) {
    int[] newIndices = Arrays.copyOf(selectedIndices, selectedIndices.length);

    for (int i = 0; i < selectedIndices.length; i++) {
        if (selectedIndices[i] != i) {
            swap(actions, selectedIndices[i], selectedIndices[i] - 1);
            newIndices[i]--;
        }
    }

    return newIndices;
}