public static void nestedLoops(int currentLoop) {
    if (currentLoop == numberOfLoops) {
        printLoops();
        return;
    }

    for (int counter=1;counter<=numberOfIterations;counter++) {
        loops[currentLoop] = counter;
        nestedLoops(currentLoop + 1);
    }
}