// recreate the array with size equals firstPart length
splitD = new int[charArray1.length];
for (int i = 0; i < charArray1.length; i++) 
{
    // convert char to int
    splitD[i] = Character.getNumericValue(charArray1[i]);
    count++;
}