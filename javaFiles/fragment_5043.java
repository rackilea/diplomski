class Test{

    static void print(int[][] a){
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a[0].length;j++) 
                System.out.print(a[i][j]+" ");
            System.out.println();
        }
    }

    public static void main(String[]args){

        java.util.Random r = new java.util.Random();
        int[][] a = new int[10][2];
        for (int i=0;i<a.length;i++){
            a[i][0]=i+1;
            a[i][1]=r.nextInt(100);
        }

        print(a);
        System.out.println();

        java.util.Arrays.sort(a, 
            new java.util.Comparator<int[]>(){
                public int compare(int[]a,int[]b){
                    return a[1]-b[1];
                }
        });

        print(a);
    }
}