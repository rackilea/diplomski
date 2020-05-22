public static void main(String[] args) {
    int testArray[][] = new int[10][10];
    for (int i = 0; i < 10; i++) {
        testArray[i][i] = 1;
        testArray[9-i][i] = 1;
    }
    testArray[4][7] = 1;

    System.out.println("Array before");

    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            System.out.print(testArray[j][i] + " ");
        }
        System.out.println("");
    }

    fillArea(6,8,0,7,testArray);

    System.out.println("Array after");
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            System.out.print(testArray[j][i] + " ");
        }
        System.out.println("");
    }
}

 public static void fillArea(int x, int y, int original, int fill, int[][] arr) {
     int maxX = arr.length - 1;
     int maxY = arr[0].length - 1;
     int[][] stack = new int[(maxX+1)*(maxY+1)][2];
     int index = 0;         

     stack[0][0] = x;
     stack[0][1] = y;
     arr[x][y] = fill;

     while (index >= 0){
         x = stack[index][0];
         y = stack[index][1];
         index--;            

         if ((x > 0) && (arr[x-1][y] == original)){
             arr[x-1][y] = fill;
             index++;
             stack[index][0] = x-1;
             stack[index][1] = y;
         }

         if ((x < maxX) && (arr[x+1][y] == original)){
             arr[x+1][y] = fill;
             index++;
             stack[index][0] = x+1;
             stack[index][1] = y;
         }

         if ((y > 0) && (arr[x][y-1] == original)){
             arr[x][y-1] = fill;
             index++;
             stack[index][0] = x;
             stack[index][1] = y-1;
         }                

         if ((y < maxY) && (arr[x][y+1] == original)){
             arr[x][y+1] = fill;
             index++;
             stack[index][0] = x;
             stack[index][1] = y+1;
         }                          
     }
 }