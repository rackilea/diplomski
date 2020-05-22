for (int i = 0; i < seats.length; i++) {
        for (int j = 0; j < seats[i].length; j++) {
            if (seats[i][j] == 0) {
                return "Next available seat at position: [" + i + "][" + j + "]";
            }
        }
 }
 return "No seat available";