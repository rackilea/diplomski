char right = col+1 < this.cols ? this.Maze[row][col + 1] : 'S';
char down = row+1 < this.rows ? this.Maze[row + 1][col] : 'S';
char left = col-1 >=0 ? this.Maze[row][col - 1] : 'S';
char up =row-1 >=0 ?  this.Maze[row - 1][col]: 'S';



public class RecursionMaze {  

private static char[][] Maze = new char[20][20];
private int rows;
private int cols;
private int rowStart, colStart;
private String outputFilename;

public RecursionMaze(String filename) throws IOException {
    try {
        this.outputFilename = filename;
        Scanner reader = new Scanner(new File(filename));
        StringBuilder sb = new StringBuilder();
        while (reader.hasNext()) {
            sb.append(reader.nextLine());
            this.rows++;
        }
        this.cols = sb.length() / this.rows;
        this.Maze = new char[this.rows][this.cols];
        int m = 0;
        System.out.println();
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.Maze[i][j] = sb.charAt(m++);
            }
        }
        reader.close();
        findStart();
        Solve(this.rowStart, this.colStart);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
        System.out.println("ERROR : " + e.getMessage());
    }
}

private void findStart() {
    for (int i = 0; i < this.rows; i++) {
        for (int j = 0; j < this.cols; j++) {
            if (Maze[i][j] == 'S') {
                this.rowStart = i;
                this.colStart = j;
            }
        }
    }
}

private boolean Solve(int row, int col) {
    char right = col + 1 < this.cols ? this.Maze[row][col + 1] : 'S';
    char down = row + 1 < this.rows ? this.Maze[row + 1][col] : 'S';
    char left = col - 1 >= 0 ? this.Maze[row][col - 1] : 'S';
    char up = row - 1 >= 0 ? this.Maze[row - 1][col] : 'S';

    if (right == 'G' || left == 'G' || up == 'G' || down == 'G') {
        this.Maze[row][col] = '+';

        try {
            File file = new File(this.outputFilename + " solved");

            PrintWriter writer = new PrintWriter(file);
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.cols; j++) {
                    writer.print(this.Maze[i][j]);
                }
                writer.println();
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR : " + e.getMessage());
        }
        return true;
    }

    boolean solved = false;

    if (this.Maze[row][col] != 'S') {
        this.Maze[row][col] = '+';
    }
    if (right == '.' && !solved) {
        solved = Solve(row, col + 1);
    }
    if (down == '.' && !solved) {
        solved = Solve(row + 1, col);
    }
    if (left == '.' && !solved) {
        solved = Solve(row, col - 1);
    }
    if (up == '.' && !solved) {
        solved = Solve(row - 1, col);
    }
    if (!solved) {
        this.Maze[row][col] = '.';
    }
    return solved;

}

public static void main(String agrs[]) throws Exception {
    try {
        new RecursionMaze("/Users/himani.agarwal/Documents/test100/host-service-user/src/main/resources/Maze.txt");
        System.out.println("File has been outputed.");
    } catch (Exception e) {
        System.out.println("ERROR : " + e.getMessage());
        e.printStackTrace();
    }

}
}