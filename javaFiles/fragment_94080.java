public void updateColony() {
    int [][] nextStep = new int[colony.length][colony[0].length];
    for (int i = 0; i < colony.length; i++) {
        for (int j = 0; j < colony[i].length; j++) {
            evolution(nextStep, i, j);
        }
    }
    colony = nextStep;
}