while(scanner.hasNextLine())
{
    String line = scanner.nextLine();
    tempList = new ArrayList<String>();
    permutation("", line);
    permutacii.put(line, tempList);
}