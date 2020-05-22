public double[][] cityMatrix() {
    double[][] cityMatrix = new double[FileReader.cities.size()][2];

    for (int i = 0; i < FileReader.cities.size(); i++){
        City c = FileReader.cities.get(i);
        cityMatrix[i][0] = c.getX();
        cityMatrix[i][1] = c.getY();
    }
    return cityMatrix;
}