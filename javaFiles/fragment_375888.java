/* Array index 0 and 1 now contains the string numerical 
   values for First Row and First Column. Array index 2 and
   3 now contains the string numerical values for Second Row 
   and Second Column. If you just can't wrap your head around 
   dealing with Arrays and indexes from this point then do 
   something like the following:     */

// Convert String Array elements to integers
row_1 = Integer.parseInt(rowCol[0]);
col_1 = Integer.parseInt(rowCol[1]);
row_2 = Integer.parseInt(rowCol[2]);
col_2 = Integer.parseInt(rowCol[3]);

// Display what was provided.
System.out.println(border2);
System.out.println("Row 1/Column 1  = " + row_1 + "/" + col_1 + LS
        + "Row 2/Column 2  = " + row_2 + "/" + col_2);
System.out.println(border2 + LS);