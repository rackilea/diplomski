public static <T extends Comparable <? super T> >void bubbleSort  (T[] data)
{
    Boolean swapped = true;
    int stop = data.length -1;


     while (swapped) {
        swapped = false;

        for (int x = 0; x < stop ; x++ ) {
             bubbleCount++;
            //if x smaller than x +1 swap
           if ( data[x].compareTo(  data[x+1]   ) > 0 ) { 

                  swap(x, x+1, data );
                  swapped = true;
           }//end if 

           stop --; // needs to go outside the for

       }//end for 

    }//end while
}//end  method============================================================