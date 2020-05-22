row[4].add(button[18]);
for (int i = 0; i < 14; i++) {
    int ndx = 1 + (i / 4);
    row[ndx].add(button[i]);
}
for (int i = 1; i < 5; i++) {
    row[i].add(button[13 + i]);
    add(row[i]);
}