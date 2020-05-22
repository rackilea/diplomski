if(charArray1.length > 5) // heavy hard-code, would prefer something better
    throw new IllegalArgumentException("Maximum 5 digits, on both decimal sides.");
    // watch out of ArrayIndexOutOfBoundsException

for (int i = charArray1.length - 1, j = splitD.length -1 ;
                                    i >=0 && j >=0; i--, j--) 
{
    // convert char to int
    splitD[j] = Character.getNumericValue(charArray1[i]);
    count++;
}