public static ArrayList<Integer> processFile (String filename) throws IOException, FileNotFoundException
{
    BufferedReader inputReader = new BufferedReader (new InputStreamReader(new FileInputStream("integers.txt")));
    String line;
    ArrayList<Integer> list = new ArrayList<>();
    while ((line = inputReader.readLine()) != null) {
        int number = Int.parseInt(line);
        list.add(number);
    }
    inputReader.close();
    return list;
}