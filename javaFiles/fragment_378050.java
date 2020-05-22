public static void main(String[] args){
    int size = 9;

    int[][] board= new int[size][size];
    board[0] = Util.createOrderedArray(size, 1);

    for(int x=1; x<size; x++){          
        board[x] = Util.createOrderedArray(size, 1);
        do{
            Util.shuffle(board[x]);
        }while(!Util.compare2DArray(board[x], board, 0, x));        
    }       
    Util.print(board);  
}