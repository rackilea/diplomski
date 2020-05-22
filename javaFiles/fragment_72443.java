int firstFree = -1;
for (int j = 0 ; j != 5 ; i++) {
    if (!seat[j]) {
        firstFreeSeat = j;
        break;
    }
}
if (firstFreeSeat == -1) {
    System.out.printl("Sorry!");
}