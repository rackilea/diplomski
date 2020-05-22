public static Map<String, String> ParseParams(String string)
{
    Map<String, String> params = new HashMap<String, String>();
    String[] lines = string.split("\n");
    for(String line : lines)
    {
        String[] splittedLine = line.split("=");
        params.put(splittedLine[0], splittedLine[1]);
    }
    return params; // Get a param with params.get(key);
}