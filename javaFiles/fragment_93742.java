int min = Math.min(colorArray.length, colorArray[0].length);

for (int r = 0; r < min; r++) {
    char[] row = colorArray[r + Math.max(0, colorArray.length - min)];
    for (int i = 0; i <= r; i++) {
        row[row.length - 1 - i] = true;
        gui.update(colorArray);
    }
}