public boolean areThereAnyAvailableSeats() {
    for (int row = 0; row < getRows(); row++) {
        for (int column = 0; column < getSeatsPerRow(); column++) {
            if (!seat[userRow][userSeatPerRow]) {
                return true;
            }
        } 
    }
    return false;
}