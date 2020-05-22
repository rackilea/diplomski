private int row, column;
private boolean inKm;

private void setCities(int row, int column) {
    this.row = row;
    this.column = column;
}

private void setKm(boolean inKm) {
    this.inKm = inKm;
}

// one place to set the distance text
private void updateDistanceText() {
    String text = fileData[row+1][column+1];
    if (inKm) {
        text = String.valueOf(
                   MetricConverter.milesToKilometers(Double.valueOf(text)));
    }
    distanceText.setText(text);        
}