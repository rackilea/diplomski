public TheaterSeatSeller(int[][] newSeats) {
    seats = new int[newSeats.length][newSeats[0].length];
    for (int i = 0; i < newSeats.length; i++) {
        for (int j = 0; j < newSeats[i].length; j++) {
            seats[i][j] = newSeats[i][j];
            System.out.println(seats[i][j]);
        }
    }

}