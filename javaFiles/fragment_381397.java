public String toString()
{
    String returnStr = "Stack: [";
    for(int i = 0; i < length; i++)
    {
        returnStr+= array[i] + ", ";
    }
    returnStr += "]";

   return returnStr;
}