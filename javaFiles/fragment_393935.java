public static List<String> generateAllPossibleStrings(String start, String end) {
    if(start==null||end==null)
        return null;
    if (start.length() != end.length())
        return null;
    int n = start.length();
    List<String> variants = new ArrayList<>();
    char startArray[] = start.toCharArray();
    char endArray[] = end.toCharArray();
    char currentArray[] = Arrays.copyOf(startArray, startArray.length);
    variants.add(new String(currentArray));

    //We check if the start string is really above the end string as specified
    //We output an empty string if it is not the case
    boolean possible = true;
    for(int i = 0; i<n; i++)
        possible = possible && (startArray[i]<=endArray[i]);
    if (!possible)
        return variants;


    while(!end.equals(new String(currentArray))){
        currentArray[n-1]+=1;
        int i = n-1;
        while(currentArray[i]>endArray[i]){
            currentArray[i]=startArray[i];
            i--;
            currentArray[i]++;
        }
        variants.add(new String(currentArray));
    }

    System.out.println(Arrays.toString(variants.toArray()));
    return variants;
}