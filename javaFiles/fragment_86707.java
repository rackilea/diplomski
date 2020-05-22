private static void permutation(String prefix, String str, ArrayList<String> tempList)
{
    int n = str.length();
    if (n == 0) 
        tempList.add(prefix);
    else 
    {
        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i),
                        str.substring(0, i) + str.substring(i+1),
                        tempList);
    }
}