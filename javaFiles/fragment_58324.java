// Call this method for a required target
public static String getKey(String target) {
    Map<String, String> keyValueMap = loadKeyValueMap();
    return keyValueMap.get(target);
}

//load the keys and values only once from your input data file.
public static Map<String, String> loadKeyValueMap()
{
    File file = new File("data.txt");
    Scanner reader = null;
    try
    {
        reader = new Scanner(file);
    } catch (FileNotFoundException e)
    {
        e.printStackTrace();
    }

    Map<String, String> map = new HashMap<>();

    while (reader.hasNextLine())
    {
        String nextLine = reader.nextLine();
        String[] split = nextLine.split(":");
        if (split.length() >= 2) map.put(split[0].trim(), split[1].trim());
        else break;
    }
    return map;
}