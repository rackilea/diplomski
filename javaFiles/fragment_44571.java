Assuming your Hashtable is global:

public void addGoals(String name, int goals)
{
     goalScorers.put(name, goalScorers.get(name) + goals);  
 }