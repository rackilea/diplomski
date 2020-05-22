public String makeArrayListFlatfileString(List<List<String>> listOfLists)
{
    StringBuilder sb = new StringBuilder();
    if (!listOfLists.isEmpty()) {
        // this assumes all lists are the same length
        int listLengths = listOfLists.get(0).size();
        for (int i=0; i<listLengths; i++)
        {
            for (List<String> list : listOfLists)
            {
                sb.append(list.get(i)).append("\n");
            }
            sb.append("\n");  // blank line after column grouping
        }
    }
    return sb.toString();
}