for (int counter = left ; counter < list.length ; counter++)
{ 
  occurence = 0; //< initialize to 0
  while ( right >= left )
  {
      if ( list[left] == list[right] )
      {
         occurence++;
       }
           right--;
   }
   right = (list.length)-1;
       //remove 4 after "occurance +"
   System.out.println ("The number " + list[left] + 
                                            " was added " + occurence + " times");
 }