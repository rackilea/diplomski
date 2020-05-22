// vertical dimension (i:= line index)
for (int i =0; i< 2* tmp +1 ; ++i){
        if(i!=tmp){ //handling of middle-line corner case

            // horizontal dimension (j:= row index)
            for (int j=0; j< 2*tmp ; ++j){
                if (condition(tmp, i,j)){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }

            if(i!=2 * tmp) { // handling of last line corner case
                System.out.println();
            }
        }
    }

    private boolean condition(int tmp, int i, int j) {

        // return true if and only if the (i, j) pixel is within the central diamond
        return Math.abs(tmp-i) + Math.abs(tmp-j) <= tmp;        
    }