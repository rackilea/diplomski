//Use else if and define the condition like you normally do for an if statement
            if(keyCode == KeyEvent.VK_LEFT) {

                if (tileLeft == Contents.EMPTY || tileLeft == Contents.GOAL) {
                    levelData[i][k] = Contents.EMPTY;
                    levelData[i-1][k] = Contents.PLAYER;
                }

            } else if(keyCode == KeyEvent.VK_UP) {

                if (tileUp == Contents.EMPTY || tileUp == Contents.GOAL) {
                    levelData[i][k] = Contents.EMPTY;
                    levelData[i][k+1] = Contents.PLAYER;
                }

            }else if(keyCode == KeyEvent.VK_RIGHT) {

                if (tileRight == Contents.EMPTY || tileRight == Contents.GOAL) {
                    levelData[i][k] = Contents.EMPTY;
                    levelData[i+1][k] = Contents.PLAYER;
                }

            }else if(keyCode == KeyEvent.VK_DOWN) {

                if (tileDown == Contents.EMPTY || tileDown == Contents.GOAL) {
                    levelData[i][k] = Contents.EMPTY;
                    levelData[i][k-1] = Contents.PLAYER;
                }

            }

            /**
             * Alternatively you could use a switch case statement
             * The same principle with the if statement above,  will give you the same result
             */
            switch (keyCode) {

                case KeyEvent.VK_LEFT:

                    if (tileLeft == Contents.EMPTY || tileLeft == Contents.GOAL) {
                        levelData[i][k] = Contents.EMPTY;
                        levelData[i-1][k] = Contents.PLAYER;
                    }

                    break;

                case KeyEvent.VK_UP:

                    if (tileUp == Contents.EMPTY || tileUp == Contents.GOAL) {
                        levelData[i][k] = Contents.EMPTY;
                        levelData[i][k+1] = Contents.PLAYER;
                    }

                    break;

                case KeyEvent.VK_RIGHT:

                    if (tileRight == Contents.EMPTY || tileRight == Contents.GOAL) {
                        levelData[i][k] = Contents.EMPTY;
                        levelData[i+1][k] = Contents.PLAYER;
                    }

                    break;

                case KeyEvent.VK_DOWN:

                    if (tileDown == Contents.EMPTY || tileDown == Contents.GOAL) {
                        levelData[i][k] = Contents.EMPTY;
                        levelData[i][k-1] = Contents.PLAYER;
                    }

                    break;
            }