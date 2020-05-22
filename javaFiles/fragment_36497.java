private int mouseCol;
private int mouseRow;

int[][] maze;

private final String LEFT       = "left";
private final String LEFT_UP    = "left_up";
private final String LEFT_DOWN  = "left_down";
//Etc

public String getRandomMove(){
    List<String> moves = getValidMoves();
    //pick a random one
}

public List<String> getValidMoves(){
    List<String> validMoves = new ArrayList<>();
    //Check left
    if(mouseCol != 0 && maze[mouseRow][mouseCol-1] == 0){
        validMoves.add(LEFT);
    }
    //Check left_up
    if(mouseRow != 0 && mouseCol != 0 && maze[mouseRow-1][mouseCol-1] == 0){
        validMoves.add(LEFT_UP);
    }
    //Etc
}