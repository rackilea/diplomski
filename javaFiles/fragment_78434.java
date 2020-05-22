public class Frame{

    /*You may adjust ROW or COLUMN
    * You may print a rectangular frame
    * by setting ROW = 6 and COLUMN = 12
    */
    private final static int ROW = 4; 
    private final static int COLUMN = 4;

    //Need not to change
    private final static int I_MIN = 1;
    private final static int I_MAX = ROW;
    private final static int J_MIN = 1;
    private final static int J_MAX = COLUMN;

    public static void main(String[] args) {

        //always start from i=1 and j=1
        for(int i=1; i<=ROW; i++){
            for(int j=1; j<=COLUMN; j++){

                if(isOnMargin(i,j)){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
    }//main()

    /*
    * This method determine whether an (i,j) 
    * is on margin. In main method if an (i,j)
    * on margin then print "*" or print " ".
    */
    private static boolean isOnMargin(int i, int j){

        if(i==I_MIN || i==I_MAX){
            return true;
        }
        else if(j==J_MIN || j==J_MAX){
            return true;
        }
        return false;
    }

}