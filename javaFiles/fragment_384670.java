ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>():
while(input_file.hasNextLine())
{
    String line = input_file.nextLine();
    List<String> myList = new ArrayList<String>(Arrays.asList(line.split(",")));
    result.add(myList);
}