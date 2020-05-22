public static int[] processFile (String filename) throws IOException, FileNotFoundException
{
    BufferedReader inputReader = new BufferedReader (new InputStreamReader(new FileInputStream("integers.txt")));
    String line;
    ArrayList<Integer> list = new ArrayList<>();
    while ((line = inputReader.readLine()) != null) {
        int number = Int.parseInt(line);
        list.add(number);
    }
    inputReader.close();
    return convertIntegers(list);
}

public static int[] convertIntegers(List<Integer> integers)
{
    int[] ret = new int[integers.size()];
    Iterator<Integer> iterator = integers.iterator();
    for (int i = 0; i < ret.length; i++)
    {
        ret[i] = iterator.next().intValue();
    }
    return ret;
}