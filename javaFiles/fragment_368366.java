public void fillSection(String[][] data) {
    data = new String[3][3];
    int x = 0; // This never changes?
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            fields[x].setText(data[i][j]);
        }
    }
}