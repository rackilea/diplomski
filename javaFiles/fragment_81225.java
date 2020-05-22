int penDimension = 10;
        int destX = 2;
        int destY = 2;
        int xpos = 5;
        int ypos = 5;

        // Add this to keep track of no moves through each square
        int[][] moveCounts = new int[penDimension][penDimension];

        Random r = new SecureRandom();
        long noMoves = 0;
        while (xpos != destX || ypos != destY) {
            switch (r.nextInt(4)) {
            case 0 : xpos++; break;
            case 1 : xpos--; break;
            case 2 : ypos++; break;
            case 3 : ypos--; break;
            }
            if (xpos < 0) xpos = 0;
            if (ypos < 0) ypos = 0;
            if (xpos > penDimension) xpos = penDimension;
            if (ypos > penDimension) ypos = penDimension;
            noMoves++;

            // Add this to keep track of no moves through each square
            moveCounts[ypos][xpos]++;

        }
        System.out.println("Number of moves: " + noMoves);