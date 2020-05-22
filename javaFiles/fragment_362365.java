public class TestArray2 {
  public static void main(String[] args){

    int [][] a = new int[5][5];
    for(int i=0; i<a.length;i++){

        for(int j=0;j<a[i].length;j++){
            int x = j;
        if(x%2 == 0){
            a[i][j] = 0;
        }
        else  {
            a[i][j] = 1;
        }
    }

    }
    printArray(a);
  }
  public static void printArray(int[][] a) {
    for (int i = 0; i < a.length; i++) {
        for (int j = 0; j < a[i].length; j++) {
            System.out.print(a[i][j] + " ");
        }
        System.out.println();
    }
  }

}