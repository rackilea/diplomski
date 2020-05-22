// First split the input String into an array,
// each element containing a String to be parse as an int
String[] intsToParse = degree.split(" ");

int[] info = new int[intsToParse.length];

// Now just parse each part in turn
for (int i = 0; i < info.length; i++)
{
    info[i] = Integer.parseInt(intsToParse[i]);
}