public class Locks{
    public static void main(String[] args) {
        int [][] locks = {
            {39,6,75,88,15,57},
            {9,2,58,68,48,64},
            {29,55,16,67,8,91},
            {40,54,66,22,32,25},        
            {49,1,17,41,14,30},
            {44,63,10,83,46,3}};
        int i, j;
        int total = 419;
        int dims = 6;               // number of dimensions in array
        int loops = 1; 
        for(i = 0; i < dims; ++i)   // maximum number of elements to test 
             loops *= dims;
        for(i=0; i < loops; ++i) {  // loop over all possibilities
            int cTotal = 0;         // Total for this selection of 6 columns
            int rTotal = 1;
            for(j = 0; j < dims; ++j) {       // generate six array indexes
                cTotal += locks[j][i / rTotal % dims];
                rTotal *= dims;
            }
            rTotal = 1;
            if(cTotal == total) {
                for(j = 0; j < dims; ++j) {
                    System.out.println(i / rTotal % dims);
                    rTotal *= dims;
                }
                return;
            }
        }
    }
}