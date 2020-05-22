// Separate the pairs into array elements
String[] pairs = viesti.split(" ");
Map<Integer, Character> codeMap = new HashMap<Integer, Character>();
char[] result = new char[pairs.length];
char curChar = 'A';
// Iterate over the pairs
for (int i = 0; i < pairs.length; i++)
{
    if (curChar > 'Z')
    {
        throw new IndexOutOfBoundsException("Too many code points");
    }

    // Parse the pair as an integer
    int hex = Integer.parseInt(pairs[i], 16);

    // Add character to result set
    if (!codeMap.containsKey(hex))
    {
        codeMap.put(hex, curChar);
    }
    else curChar-=1;
    result[i] = codeMap.get(hex);

    // Increment character
    curChar++;
}
String viesti2 = new String(result);