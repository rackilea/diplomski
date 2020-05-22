boolean foundS= false;
    boolean foundM = false;
    for (int i = 0;i < 4;i ++) {
        for (int j = 0;j < 4;j ++) {
            if (Board[i][j].equalsIgnoreCase("S")) {
                foundS = true;
                continue;
            }
            if (Board[i][j].equalsIgnoreCase("M")) {
                foundM = true;
                continue;
            }
        }
    }
    if (foundS && foundM) {
        System.out.println("both");
    } else if (foundS) {
        System.out.println("found S");
    } else if (foundM) {
        System.out.println("found M");
    } else {
        System.out.println("none");
    }