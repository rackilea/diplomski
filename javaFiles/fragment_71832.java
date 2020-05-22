if (isVisible[x][y]) {
                                System.out.print(" " + mineField[x][y] + "  ");
                        } else {
                                System.out.print("[" + mineField[x][y] + "] ");
                                if (mineField[x][y] != '*') {
                                        succes = false;
                                }
                        }