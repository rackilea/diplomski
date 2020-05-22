import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Driver {

    public static void main(String[] args) {
        int rows = 20;
        int columns = 20;
        char [][] maze = new char [rows][columns];//maze size
        Scanner scan = new Scanner(System.in);

        try {
            File maze_file = new File("src/main/maze.txt");
            System.out.println(maze_file.getAbsolutePath());
            Scanner s = new Scanner(maze_file);
            while(s.hasNext()) {
                for(int row = 0; row < maze.length;row++) {
                    String line = s.nextLine();
                    for (int col = 0; col < 20; col++) {
                        maze[row][col] = line.charAt(col);
                    }
                }
            }
            s.close();
        } catch(FileNotFoundException e) {
            System.out.println("ERROR. FILE NOT FOUND");
        }

        MazeGame d = new MazeGame();
        d.print(maze);

        System.out.println("You will now enter the row and column # that you wish to start at.");
        System.out.println("Enter which row you would like to start at(Row # 0-19) ");
        int row1 = scan.nextInt();//fetchs row number from user
        System.out.println("Enter which column you would like to start at (Column# 0-19) ");
        int column1 = scan.nextInt();//fetches column number from user

        if(row1 >= maze.length || column1 >= maze[0].length)
            System.out.println("The number entered is invalid");
        else if(maze[row1][column1]=='E')
            System.out.println(" Can not start at exit");
        else if(maze[row1][column1]=='1')
            System.out.println("You can not start at a value containing 1, only 0");
        else
            d.solveMaze(maze, row1, column1);

    }

}