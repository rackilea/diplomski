public class SaddlePointerFinder{

    public static void main(String[] args){

       int [] [] matrix = {   
        { 7, 2 },
        { 1, 3 },
        { 5, 8 },
       };

       // i loops though columns
       for(int x = 0; x<matrix[0].length; x++){    

       // this is to store the highest on the ROW
        int highestOnTheRow = -1;
       // this is to store the index of that highest value
       int indexOfHighest = -1;

       // x loops through rows
       for(int y = 0; y<matrix.length; y++){
            if(matrix[y][x] > highestOnTheRow) {
                // update the highest
                highestOnTheRow = matrix[y][x];
                indexOfHighest = y;
            }
        }

        // After checking the whole row and finding the highest, check if it's highest on the column
        boolean highest = true;

        // here, i checks goes through each row using that column.
        for(int i = 0; i<matrix[0].length; i++){
            if(matrix[indexOfHighest][i] > highestOnTheRow) {
                // one which was higher was found :(
                highest = false;
            }
        }
        if(highest){
               System.out.println("If the forumla is correct, this is a saddle point: " + highestOnTheRow);
        }
    }
}