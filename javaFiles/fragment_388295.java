public static String [][] to2dim (String source, String outerdelim, String innerdelim) {
    // outerdelim may be a group of characters
    String [] sOuter = source.split ("[" + outerdelim + "]"); 
    int size = sOuter.length;
    // one dimension of the array has to be known on declaration:
    String [][] result = new String [size][]; 
    int count = 0;
    for (String line : sOuter)
    {
        result [count] = line.split (innerdelim);
        ++count;
    }
    return result;
}