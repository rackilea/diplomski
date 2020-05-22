public class Fencing {

    public static void main(String[] args) {
        boolean b = true;
        double corner = 0;
        double core = 0;
        double side = 0;

        int[][] map = { 
            { 0, 1, 1, 0 }, 
            { 1, 1, 1, 1 }, 
            { 1, 1, 1, 1 }, 
            { 1, 1, 0, 1 } 
        };

        firstBlock:{
            int i = 0;
            int j = 0;
            for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {
                if (map[i][j] != 1 && map[i][j] != 0) {
                    b = false;
                    System.out.println("--> A value of " + map[i][j] + " was found at " + i + "," + j);
                }
            }
        }
        if (b == false && i == 4) {
            System.out.println("The map is invalid");
            return;
        } else {
            System.out.println("Map is valid");
        }
        if (map[0][0] == 1) {
            corner += 5;
            if (map[1][0] == 1 && map[0][1] == 1) {
                corner += 0;
            }
            if (map[1][0] != 1 && map[0][1] != 1) {
                corner += 5;
            }
            if (map[1][0] != 1 && map[0][1] == 1 || map[1][0] == 1 && map[0][1] != 1) {
                corner += 2.5;
            }
        } else {
            corner += 0;
        }
        if (map[0][3] == 1) {
            corner += 5;
            if (map[1][3] == 1 && map[0][2] == 1) {
                corner += 0;
            }
            if (map[1][3] != 1 && map[0][2] != 1) {
                corner += 5;
            }
            if (map[1][3] != 1 && map[0][2] == 1 || map[1][3] == 1 && map[0][2] != 1) {
                corner += 2.5;
            }
        } else {
            corner += 0;
        }
        if (map[3][0] == 1) {
            corner += 5;
            if (map[3][1] == 1 && map[2][0] == 1) {
                corner += 0;
            }
            if (map[3][1] != 1 && map[02][0] != 1) {
                corner += 5;
            }
            if (map[3][1] != 1 && map[2][0] == 1 || map[3][1] == 1 && map[2][0] != 1) {
                corner += 2.5;
            }
        } else {
            corner += 0;
        }
        if (map[3][3] == 1) {
            corner += 5;
            if (map[3][2] == 1 && map[2][3] == 1) {
                corner += 0;
            }
            if (map[3][2] != 1 && map[2][3] != 1) {
                corner += 5;
            }
            if (map[3][2] != 1 && map[2][3] == 1 || map[3][2] == 1 && map[2][3] != 1) {
                corner += 2.5;
            }
        } else {
            corner += 0;
        }
        System.out.println("Corner fencing = " + corner);
        }
       secondBlock:{ 
            int i = 0;
            int j = 0;
            for (i = 1; i < 2; i++) { // Top
            if (map[0][j] == 1) {
                side += 2.5;
                if (map[i + 1][0] == 1 && map[i - 1][0] == 1) {
                    side += 0;
                }
                if (map[i + 1][0] != 1 || map[i - 1][0] != 1) {
                    side += 2.5;
                }
                if (map[i + 1][0] != 1 && map[i - 1][0] != 1) {
                    side += 5;
                }
            } else {
                side += 0;
            }
        }
        System.out.println("After the first row, fencing = " + side);}
        thirdBlock:{
            int i = 0;
            int j = 0;
            for (i = 1; i < 2; i++) { // Bottom
            if (map[i][3] == 1) {
                side += 2.5;
                if (map[i + 1][3] == 1 && map[i - 1][3] == 1) {
                    side += 0;
                }
                if (map[i + 1][3] != 1 || map[i - 1][3] != 1) {
                    side += 2.5;
                }
                if (map[i + 1][3] != 1 && map[i - 1][3] != 1) {
                    side += 5;
                }
            } else {
                side += 0;
            }
        }
        System.out.println("After the bottom row, fencing = " + side);}
        fourthBlock:{
            int i = 0;
            int j = 0;
        for (j = 1; j < 3; j++) {// Right
            if (map[3][j] == 1) {
                side += 2.5;
                if (map[3][j + 1] == 1 && map[3][j - 1] == 1) {
                    side += 0;
                }
                if (map[3][j + 1] != 1 || map[3][j - 1] != 1) {
                    side += 2.5;
                }
                if (map[3][j + 1] != 1 && map[3][j - 1] != 1) {
                    side += 5;
                }
            } else {
                side += 0;
            }
        }
        System.out.println("After the first column, fencing = " + side);}
        lastBlock:{
            int i = 0;
            int j = 0;
        for (j = 1; j < 3; j++) {// Left
            if (map[0][j] == 1) {
                side += 2.5;
                if (map[0][j + 1] == 1 && map[0][j - 1] == 1) {
                    side += 0;
                }
                if (map[0][j + 1] != 1 || map[0][j - 1] != 1) {
                    side += 2.5;
                }
                if (map[0][j + 1] != 1 && map[0][j - 1] != 1) {
                    side += 5;
                }
            } else {
                side += 0;
            }
        }
        System.out.println("After the last column, fencing = " + side);}
    }
}