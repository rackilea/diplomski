import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Maze {

    //keep reference to start point
    int startRow, startCol;

    //keep reference to addresses (row, col) that has been checked
    List<Integer[]> visited;

    //a stack that represents the path (solution)
    Stack<Integer[]> path;

    public Maze(int startRow, int startCol) {

        this.startRow = startRow; //add: check input validity
        this.startCol = startCol;
        visited = new ArrayList<>();
        path = new Stack<>();
    }

    public static int[][] mazeValues = new int[][] {
        {0,1,0,0,0},
        {0,0,0,1,0},
        {1,1,1,0,0},
        {1,1,1,0,1},
        {0,0,0,0,0}
    };

    void solve(){

        boolean isSolved = solve(startRow, startCol);
        if( isSolved ) {
            pathFound();
        } else {
            noPathFound();
        }
    }


    private boolean solve(int row, int col) {

        //check if target found
        if(isTargert(row,col)) {
            //add target to path
            path.push(new Integer[]{row,col});
            return true;
        }

        //check if address is a wall
        if(isWall(row,col)) {
            return false;
        }

        //check if visited before
        if(isVisited(row, col)) {
            return false;
        }

        //mark as visited
        visited.add(new Integer[]{row,col});

        //add to path
        path.push(new Integer[]{row,col});

        //check all neighbors (allows diagonal move)
        for (int rowIndex = row-1; rowIndex <= (row+1) ; rowIndex++ ) {

            for (int colIndex = col-1; colIndex <= (col+1) ; colIndex++ ) {

                if( (rowIndex == row) && (colIndex == col)) {//skip current address
                    continue;
                }

                if( ! withInMaze(rowIndex, colIndex)) {
                    continue;
                }

                if( solve(rowIndex, colIndex)) {
                    return true; //solution found
                }
            }
        }

        //solution not found after checking all neighbors
        path.pop(); //remove last from stack;
        return false;
    }

    //check if address is a target
    private boolean isTargert(int row, int col) {
        //target set to last row / col. Change taget as needed
        return (row == (mazeValues.length-1))&& (col == (mazeValues[0].length -1)) ;
    }

    //check if address is a wall
    private boolean isWall(int row, int col) {

        return mazeValues[row][col] == 1;
    }

    private boolean isVisited(int row, int col) {

        for (Integer[] address : visited ) {

            if((address[0]==row) && (address[1]==col)) {
                return true;
            }
        }
        return false;
    }

    //return true if rowIndex, colIndex are with in mazeValues
    private boolean withInMaze(int rowIndex, int colIndex) {

        return (rowIndex < mazeValues.length)&& (rowIndex >= 0)
                &&(colIndex < mazeValues[0].length) && (colIndex >=0);
    }

    private void noPathFound() {
        System.out.println("No path found............");

    }

    private void pathFound() {

        System.out.println("Path found");
        for (Integer[] address : path) {
            int row = address[0]; int col = address[1];
            System.out.println("Address: "+ row +"-"+ col
                                +" value: "+ mazeValues[row][col]);
        }
    }

    public static void main(String[] args) {

        Maze maze = new Maze(0,0);
        maze.solve();
    }
}