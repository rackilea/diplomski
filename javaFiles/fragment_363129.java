outer: for (int i = 0 ; i < seating.length ; i++) {
    for (int j = 0 ; j < seating[i].length ; j++) {
        if (!seating[i][j].equals("XX")) {
            seating[i][j] = "XX";
            break outer;
        }
    }
}