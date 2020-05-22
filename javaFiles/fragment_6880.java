public static void flip(int[] flp){
 System.out.println("This is the flip method");
 for ( int i = 0;  i < flp.length/2; i++){
     int e = flp.length-(1+i);
     int temp = flp[i];
     flp[i] = flp[e];
     flp[e] = temp;
    // remove print from here. else you will get half of the array
    // since flp.length/2
   }
}