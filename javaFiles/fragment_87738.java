public static Boolean isFlush(boolean[][] hand) { // 5 cards same color
    for (int i = 0; i < 4; i++) {
        int count = 0;

        for(int j = 0; j < 13; j++) {
            if(hand[i][j]) {
                count++;
            }
        }

        if(count == 5) {
            return true;
        }
    }

    return false;
}

public static Boolean isStraight(boolean[][] hand) { // straight patter 
    for (int i = 0; i < 9; i++) {
        int count = 0;

        for(int j = 0; j < 5; j++) {
            for(int k = 0; k < 4; k++) {
                if (hand[k][i + j]) {
                    count++;
                    break;
                }
            }
        }

        if(count == 5) {
            return true;
        }
    }

    return false;
}