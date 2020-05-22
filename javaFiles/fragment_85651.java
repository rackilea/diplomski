private void flipHorizontally() {
    for (int y = 0; y < totalY; y++) {
        for (int x = 0; x < totalX/2; x++) {
            String tmp = fields[totalX-x-1][y].getText();
            fields[totalX-x-1][y].setText(fields[x][y].getText());
            fields[x][y].setText(tmp);
        }
    }
}


private void flipVertically() {
    for (int x = 0; x < totalX; x++) {
        for (int y = 0; y < totalY/2; y++) {
            String tmp = fields[x][totalY - y - 1].getText();
            fields[x][totalY - y - 1].setText(fields[x][y].getText());
            fields[x][y].setText(tmp);
        }
    }
}