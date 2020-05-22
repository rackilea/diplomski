public List<List<String>> getListOfListsFromFlatfile(String data)
{
    // split into lines
    String[] lines = data.split("\\n");
    // first find out how many Lists we'll need
    int numberOfLists = 0;
    for (String line : lines){
        if (line.trim().equals(""))
        {
            // blank line means new column grouping so stop counting
            break;
        }
        else
        {
            numberOfLists++;
        }
    }
    // make enough empty lists to hold the info:
    List<List<String>> listOfLists = new ArrayList<List<String>>();
    for (int i=0; i<numberOfLists; i++)
    {
        listOfLists.add(new ArrayList<String>());
    }
    // keep track of which list we should be adding to, and populate the lists
    int listTracker = 0;
    for (String line : lines)
    {
        if (line.trim().equals(""))
        {
            // new block so add next item to the first list again
            listTracker = 0;
            continue;
        }
        else
        {
            listOfLists.get(listTracker).add(line);
            listTracker++;
        }
    }
    return listOfLists;
}