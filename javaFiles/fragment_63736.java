public static void main(String []args){

    int sum = 0;   //store all the numbers
    int t = 3;     // the starting point (it can be 3 if you want)

    while (t < 1000) {    // as long t is lower than 1000

       if ( t % 3 == 0 || t % 5 == 0) {    //check if t is divided by 3 or 5
         sum += t;             //add to sum
       }

       t++; //add 1 to t (t will increase and eventualy be bigger than 1000)
     }

     System.out.println(sum);  //print sum
  }