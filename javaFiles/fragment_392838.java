int row = 10;
int col = 10;
char[][] input = new char[row][col];
Scanner in = new Scanner(System.in);
for(int i=0; i < row; i++){
    input[i] = in.nextLine().toCharArray();
}