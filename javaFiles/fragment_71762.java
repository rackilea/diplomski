int[][] otherOptions = new int[neighbors.length][];
for (int nodeIdx = 0; nodeIdx < neighbors.length; nodeIdx++) {
    otherOptions[nodeIdx] = new int[neighbors[nodeIdx].length - 1];
    for (int i = 0, j = 0; i < neighbors[nodeIdx].length; i++) {
        if (neighbors[nodeIdx][i] != preliminaryAssignments[nodeIdx]) {
            otherOptions[nodeIdx][j++] = neighbors[nodeIdx][i];
        }
    }
}