public class YourClass{
    static boolean found = false; // the global flag
    // your existing code

    public static void Find_Path(char[][] maze, int startX, int startY){
        // ....
        for(int i = 0; i < 4 ; i++){
            // ...
            if(maze[afterX][afterY] == 'X'){
                found = true; // path found
                return;
            }
        }
        for(int i = 0; i < 4 ; i++){
            // ...
            if(found) // path already found in earlier recursive call; no need to search anymore
                return;
            else{ // path not found yet, have to continue searching
                if(maze[afterX][afterY] == 'O'){
                    Find_Path(maze, afterX, afterY);
                    if(!found){ // path not found
                        maze[afterX][afterY] = '-';
                    }
                }
            }
        }
    }
}