import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;
import java.awt.Point;

public class TestCode {
    static Point startPoint = new Point();
    static Point finishPoint = new Point();
    final static int mazeHeight = 12;
    final static int mazeWidth = 58;
    static char[][] mazePoints = new char[mazeHeight][mazeWidth];
    Stack<Point> pointsNotTraversed = new Stack<Point>();
    Point pt = new Point();
    static HashSet<Point> previousLocations = new HashSet<Point>();
    static Stack<Point> nextPoints = new Stack<Point>();

public static void main(String[] args) throws FileNotFoundException{

    System.out.println("Please enter the file name of your Maze");
    Scanner console = new Scanner(System.in);
    File f = new File(console.nextLine());
    Scanner sc = new Scanner(f);

    if(!sc.hasNextLine()){
        System.out.println("Sorry, please enter a file name with the extension, that contains a maze!");
    }
    System.out.println("So, you want to know if your maze is solvable.....?");

    for (int row = 0; row < mazeHeight && sc.hasNext(); row++) {
        final String mazeRow = sc.next(); //Get the next row from the scanner.
        mazePoints[row] = mazeRow.toCharArray(); //Convert the row into a char[].
    }
        //identify the finish point
    for(int i = 0; i < mazeHeight; i++){
        for(int j = 0; j<mazeWidth; j++){
            if(mazePoints[i][j] == 'F'){
                finishPoint = new Point(i, j);
            }       
        }
    }
    // Identify the start point
   for(int i = 0; i< mazeHeight; i++){
       for(int j = 0; j < mazeWidth; j++){
           if(mazePoints[i][j] == 'S'){
             startPoint = new Point(i , j);
           }
       }
   }
   System.out.println(isTraversable(startPoint));    
}
    public static  boolean isTraversable(Point current){

        mazePoints[current.x][current.y] = ' ';

        if(current.y < 56 && current.y > 0 && current.x > 0 && current.x < 11){
            if (mazePoints[current.x - 1][current.y] == 'O'){ // Up dir
                Point upPoint = new Point(current.x-1, current.y);
                nextPoints.push(upPoint);
            }

            if(mazePoints[current.x+1][current.y] == 'O'){ // Down dir
                Point downPoint = new Point(current.x+1, current.y);
                nextPoints.push(downPoint);
            }

            if(mazePoints[current.x][current.y + 1] == 'O'){ // to the right
                Point rightPoint = new Point(current.x, current.y+1);
                nextPoints.push(rightPoint);
            }

            if(mazePoints[current.x][current.y - 1] == 'O'){ // to the left
                Point leftPoint = new Point(current.x, current.y-1);
                nextPoints.push(leftPoint);
            }

            if(mazePoints[current.x - 1][current.y] == 'F' ||
               mazePoints[current.x + 1][current.y] == 'F' ||
               mazePoints[current.x][current.y - 1] == 'F' ||
               mazePoints[current.x][current.y + 1] == 'F'){
                System.out.println("MAZE IS SOLVABLE, YAHOOOOOO!!!!");
                return true;
            }

        }
        if(nextPoints.isEmpty()){
            return false;
        }
        else{
            current = nextPoints.pop();
        }

        return(isTraversable(current));

    }
}