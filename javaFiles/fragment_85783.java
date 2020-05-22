public void print() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                numData = data[row][col];
                if (numData == 0) {
                    System.out.print(" ");
                } else if (numData > 6) {
                    System.out.print(" X ");
                } else if (numData < 6 || numData > 0) {
                    System.out.print(" x ");
                } else {
            }
        }
        System.out.println();
    }