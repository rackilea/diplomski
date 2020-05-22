List<String[]> format(List<String[]> input)
{
    List<String[]> output = new ArrayList<String[]>();
    Set<String> users = new HashSet<String>();
    Set<String> pollSet = new HashSet<String>();
    Map<String, String> data = new HashMap<String, String>();

    for(String[] row : input) //figure out how many users and polls there are
    {
        users.add(row[1]);
        pollSet.add(row[2]);
        data.put(row[1] + "_" + row[2], row[0]); //link user_poll to Yes/No data
    }

    String[] polls = pollSet.toArray(new String[0]); //make the set be an array for easier access
    Arrays.sort(polls); //sort the polls here if you want to

    for(String user : users) //loop over users, since each row is 1 user
    {
        String[] row = new String[polls.length + 1]; //each row is poll1,poll2,...,pollN,user
        row[row.length - 1] = user;

        for(int i = 0; i < polls.length; i++)
            row[i] = data.get(user + "_" + polls[i]); //retrieve the Yes/No data for user_poll, no data fills in null
            //alternative if you want "NULL" instead of null
            //if((row[i] = data.get(user + "_" + polls[i]) == null)
                //row[i] = "NULL";

        output.add(row); //add completed row to the output
    }

    return output;
}