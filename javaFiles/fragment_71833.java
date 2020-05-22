if (isVisible[x][y]) {
                                System.out.print(" " + mineField[x][y] + "  ");
                        } else {
                                System.out.print("[ ] ");
                                if (mineField[x][y] != '*') {
                                        succes = false;
                                }
                        }