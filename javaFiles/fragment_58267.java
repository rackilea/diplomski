import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

//a stack representing cells in the path
//each cell represented by [row,col]
class Path extends Stack<int[]>{

    private Token[][] grid;

    //a path shorter than min can not surround any cell
    private static final int MIN_PATH_LEGTH = 3;

    //a collection of cells that has been tested
    private ArrayList<int[]>checked;

    //represents the cell where the search starts from
    int[] origin;
    //represents the token of the origin
    Token originToken;

    private int rows;
    private int cols;

    Path(Token[][] grid){

        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
    }

    //search for a path
    boolean findPath(int[] origin) {

        this.origin = origin;

        int row = origin[0] , col =  origin[1];

        //represents the token of the origin
        originToken = grid[row][col];

        //initialize list of checked items
        checked = new  CellsList();

        boolean found = findPath(row, col);

        if(found) {
            printPath();
        } else {
            System.out.println("No path found");
        }

        return found;
    }

    //recursive method to find path. a cell is represented by its row, col
    //returns true when path was found
    private boolean findPath(int row, int col) {

        //check if cell has the same token as origin
        if(grid[row][col] != originToken) {
            return false;
        }

        int[] cell = new int[] {row, col};

        //check if this cell was tested before to avoid checking again
        if(checked.contains(cell)) {
            return false;
        }

        //get cells neighbors
        CellsList neighbors = getNeighbors(row, col);

        //check if solution found. If path size > min and cell
        //neighbors contain the origin it means that path was found
        if((size() >= MIN_PATH_LEGTH) && neighbors.contains(origin)  ) {

            add(cell);
            return true;
        }

        //add cell to checked
        checked.add(cell);

        //add cell to path
        add(cell);

        //if path was not found check cell neighbors
        for(int[] neighbor : neighbors ) {

            boolean found = findPath(neighbor[0],neighbor[1]);
            if(found) {
                return true;
            }
        }

        //path not found
        pop(); //remove last element from stack
        return false;
    }

    //return a list of all neighbors of cell row, col
    private CellsList getNeighbors(int  row, int col) {

        CellsList neighbors = new CellsList();

        for (int colNum = col - 1 ; colNum <= (col + 1) ; colNum +=1  ) {

            for (int rowNum = row - 1 ; rowNum <= (row + 1) ; rowNum +=1  ) {

                if(!((colNum == col) && (rowNum == row))) {

                    if(withinGrid (rowNum, colNum )  ) {

                        neighbors.add( new int[] {rowNum, colNum});
                    }
                }
            }
        }

        return neighbors;
    }

    private boolean withinGrid(int colNum, int rowNum) {

        if((colNum < 0) || (rowNum <0) ) {
            return false;
        }
        if((colNum >= cols) || (rowNum >= rows)) {
            return false;
        }
        return true;
    }

    //use for testing
    private void printPath() {
        System.out.print("Path : " );
        for(int[] cell : this) {
            System.out.print(Arrays.toString(cell));
        }
        System.out.println("");
    }

    public CellsList getPath() {

        CellsList cl = new CellsList();
        cl.addAll(this);
        return cl;
    }
}