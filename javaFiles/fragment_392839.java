int row = 10;
int col = 10;
char[][] input = new char[row][col];
BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
for(int i=0; i < row; i++){
    input[i] = reader.readLine().toCharArray();
}