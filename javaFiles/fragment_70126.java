public class FindShortestPath2 {

    int lowestCost = Integer.MAX_VALUE;

    int grid[][] = {{0, 9, 0, 0},  
                   { 0, 5, 1, 1},
                   { 0, 0, 2, 0},
                   { 0, 0, 0, 0}};

    int sol[][] = new int[4][4];      //this is the path solution

    public static void main(String[] args) {
        new FindShortestPath2().start();
    }

    void start() {
        travel(new int[4][4], 0, 0, 2, 2, 0);
        System.out.println("Lowest cost: " + lowestCost);
        printPath(sol);  //print solution
    }

    public void travel(int[][] path, int cX, int cY, int eX, int eY, int cost) {
        if (cX == eX && cY == eY) {    //reach destiny cordinates
            if (cost < lowestCost) {
                lowestCost = cost;
                path[cX][cY] = 1;
                replace(sol, path);             
            }
        } else {
            path[cX][cY] = 1;         //mark path

            if (isValid(cX + 1, cY + 1, path, eX, eY)) {    //move in diagonal (rigth-down)       
                travel(path, cX + 1, cY + 1, eX, eY, cost + grid[cX + 1][cY+1]);
            }
            if (isValid(cX, cY + 1, path, eX, eY)) {        //move rigth
                travel(path, cX, cY + 1, eX, eY, cost + grid[cX][cY+1]);
            }
            if (isValid(cX + 1, cY, path, eX, eY)) {        //move down
                travel(path, cX + 1, cY, eX, eY, cost + grid[cX + 1][cY]);
            }

            path[cX][cY] = 0;       //unmark path
        }
    }


    boolean isValid(int x, int y, int[][] path, int eX, int eY) {
        //not valid if: cordinates are into grid dimensions
       if (!((x >= 0 && x < grid.length) && (y >= 0 && y < grid.length)))
           return false;

       //valid if: not visited yet, or is destiny
       if (path[x][y] == 0 || (x == eX && y == eY))
           return true;

       return true;
    }

    void replace(int[][] p1, int[][] p2) {
        for (int col = 0; col < p1.length; col++) {
            for (int ro = 0; ro < p1.length; ro++) {
                p1[ro][col] = p2[ro][col];
            }
        }
    }

    void printPath(int[][] p) {
        for (int col = 0; col < p.length; col++) {
            for (int ro = 0; ro < p.length; ro++) {
                System.out.print(p[col][ro] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}