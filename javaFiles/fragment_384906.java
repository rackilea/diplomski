int N = InputNumber(input);
char A = 'O';
char [] board = new char[N*N];
int m = (int) Math.sqrt(N); //i don't know why you need this

System.out.println("Printing " + N + " x " + N + " board...");
for(int i = 0; i < board.length; i++)
{
    board[i] = A;
    if((i%N) == 0){
        System.out.println();
    }
     System.out.print(board[i]);
}