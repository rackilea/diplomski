int i = 0;
while ((nextLine = reader.readNext()) != null) {
    for (x = 0; x <= 3; x++) {
        iaData[i][x] = Integer.parseInt(nextLine[x]);
    }
    i++;
}