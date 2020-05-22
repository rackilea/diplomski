Dry Run 1.1
 funtion G (Array (n ) ) {
   Looping over {1,2,3,4,5}{ 
       First value while looping is 1, remove it from the array;
        you have {2,3,4,5}.// store it some where.
       then
          make a recursive call to G with {2,3,4,5}
     }
 }

 Dry Run 1.2 

 funtion G (Array (n ) ) {
   Looping over {2,3,4,5}{ 
       First value while looping is 2, remove it from the array;
        you have {3,4,5}.// store it some where.
       then
          make a recursive call to G with {3,4,5}
     }
 }