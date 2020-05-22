String pin = "Sample";
char[] charArray = pin.toCharArray();
for(char c : charArray)
{
    pressButton(""+c); // to convert char to String
}