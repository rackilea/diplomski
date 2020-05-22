while(scanner.hasNextLine())
{
    String line = scanner.nextLine();
    ArrayList<String> tempList = new ArrayList<String>();
    permutation("", line, tempList);
    permutacii.put(line, tempList);
}