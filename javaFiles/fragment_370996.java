private final List<double[]> wallPositions = new ArrayList<double[]>(); 

public boolean isThereAWall(double[] userPosition) { 
    for (double entry[] : wallPositions) {
        if (Arrays.equal(entry, userPosition)) {
            return true;
        }
    }
    return false;
}