private void getNextChar() throws IOException
{
    int data = in.read(); 
    char temp = (char) data;
    currentChar = temp;
}