static boolean IsOccupied(String Seat) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 3; j++) {
                if (MSR[i][1] != null && MSR[i][1].equals(Seat)) {
                    MSR[i][2]="X";
                    return true;
                }
            }
        }
        return false;
    }