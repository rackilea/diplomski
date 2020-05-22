//Class 1
public class MazeGame {

    public void solveMaze(char [][] maze, int row1, int column1) {
        if(findpath(maze, row1, column1)) {
            print(maze, row1, column1);
            System.out.println("I am finally free!!");
        } else {
            print(maze,row1,column1);
            System.out.println(" Help me! I am trapped");
        }
    }

    public boolean findpath(char [][] maze, int a, int b) {
        // check current field
        // check if is walkable
        if(out(maze,a,b) || closed(maze,a,b) || marked(maze,a,b)) return false;
        // found exit?
        if(exit(maze,a,b)) return true;
        mark(maze,a,b);

        // go further (recursion)
        if(findpath(maze,a,b-1))  return true;
        if(findpath(maze, a, b+1))return true;
        if(findpath(maze,a-1, b)) return true;
        if(findpath(maze,a+1, b)) return true;

        //unmark this position
        unmark(maze,a,b);
        return false;
    }

    public boolean closed(char [][] maze, int a, int b) {
        return maze [a][b] == '1';
    }

    public boolean exit(char[][] maze, int a, int b) {
        return maze [a][b]=='E';
    }

    public boolean marked(char [][] maze, int a , int b) {
        return maze[a][b]=='+';
    }

    public boolean open(char [][] maze, int a, int b) {
        return maze[a][b]=='0';
    }

    public boolean out(char [][] maze, int a, int b) {
        return (a >= maze.length || b>= maze[0].length || a<0 || b<0);
    }

    public void mark(char [][] maze, int a, int b) {
        maze[a][b]='+';
    }

    public void unmark(char[][]maze, int a, int b) {
        maze[a][b] = 'x';
    }

    public void print(char [][] maze, int row1, int column1) {
        maze[row1][column1]='S';
        print(maze);
    }

    public void print(char [][] maze) {
        System.out.printf("%-4s", "");
        for(int i= 0; i< maze[0].length;i++)
            System.out.printf("%-4d", i);
        System.out.println();

        for(int i = 0; i< maze.length; i++) {
            System.out.printf("%-4d",i);
            for(int j = 0; j< maze[0].length; j++) {
                System.out.printf("%-4c", maze[i][j]);
            }
            System.out.println();
        }
    }
}