boolean seatFound = false;
outer: for (int i = 0 ; i < seating.length ; i++) {
    for (int j = 0 ; j < seating[i].length ; j++) {
        if (!seating[i][j].equals("XX")) {
            seating[i][j] = "XX";
            seatFound = true;
            break outer;
        }
    }
}
if (seatFound) {
    // a seat was successfully occupied!
} else {
    // the seats were already all full!
}