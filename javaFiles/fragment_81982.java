public static void main(String[] args){
    int[] v = {5,4,3,2,1};
    pr(v);}
    public static int [] [] pr (int [] v)
    {
        int [][] b =new int[v.length][v.length] ;
        for (int i = 0; i<v.length; i++)
        {
            for(int j=0; j<v.length;j++){
                b[i][j] = v[i] * v[j];
            }
        }

        System.out.println(b[0][0]+" "+b[0][1]+" "+b[0][2]);
        System.out.println(b[1][0]+" "+b[1][1]+" "+b[1][2]);
        System.out.println(b[2][0]+" "+b[2][1]+" "+b[2][2]);
        return b;
    }