/* Calculate and hold the MINIMUM number of characters 
   allowed to be in the supplied text file. A Ternary
   Operator is used to select the appropriate calculation.  */ 
int minimumFileLength = (desiredStringLength % 2 == 0 ? 
                         desiredStringLength/2 : 
                         (desiredStringLength/2) + 1);