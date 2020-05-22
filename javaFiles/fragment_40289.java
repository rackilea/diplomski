public boolean win_row() {
    int xTemp = x;
    int yTemp = y;
    int win = 0;
    while (yTemp != 0) {
        if (A[xTemp][yTemp] == cod) {
                win ++;
                yTemp --;
                System.out.println("Going Left: Matched");
        }
        else {
            System.out.println("Going Left: Not Matched");
            break;
        }
        if (win == 4) {
            return true;
        }
    }
    yTemp = y + 1;
    while (yTemp != 7) {
        if (A[xTemp][yTemp] == cod) {
            win ++;
            yTemp ++;
            System.out.println("Going Right: Matched");
        }
        else {
            System.out.println("Going Right: Not Matched");
            break;
        }
        if (win == 4) {
            return true;
        }
    }
    return false;
}