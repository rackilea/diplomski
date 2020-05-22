int rows = 500;

    //Calculating the largest number we will reach:
    int largest = 1;
    for(int i=1;i<=rows;i++){  

        largest=largest + i;    
    } 
    largest=largest*2;//since we only count even numbers


    int cur = 2; //current value to add to the triangle
    int rowsize = 0; //how many values to fit inside the row

    for (int i = 1; i <= rows; i ++) {

        int cursize = 0; //ammount of values currently in the row

        //filling spaces on left side
        //The value is based on how many rows we want, more rows = need for more initial spacing
        String spaces = "";
        for(int j = 0 ; j < (rows + "").length() ; j++) {
            spaces += " ";
        }
        for (int j = 0; j <= rows - i ; j++) {

            System.out.print(spaces);
        }

        while(cursize <= rowsize) {

            //For each number, we calculate how much spacing to place before it
            int len = (largest + "").length() - (cur + "").length();
            spaces = "";
            while(len != 0) {
                spaces += " ";
                len--;
            }

            System.out.print(" " + spaces + cur);
            cur += 2;
            cursize++;

        }

        System.out.println (""); //new line
        rowsize++;
    }
}