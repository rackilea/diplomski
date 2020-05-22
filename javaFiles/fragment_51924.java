public static int[] processFile (String filename) throws IOException, FileNotFoundException
{
    BufferedReader inputReader = new BufferedReader (new InputStreamReader(new FileInputStream("integers.txt")));
    String line;
    int[] array = new int[100]; // Example size of 100
    int index = 0;
    while ((line = inputReader.readLine()) != null) {
        int number = Int.parseInt(line);
        array[index++] = number;
    }
    inputReader.close();
    return array;
}