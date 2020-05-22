HashMap<String, Integer> result = new HashMap<String, Integer>(); //<agent id, amount>
for(String line: arraylist)
{
    String[] items = line.split(" ");
    String agent = items[3];
    double amount = Double.valueOf(items[2]);

    if(!result.containsKey(agent)
        result.put(agent, amount);
    else
        result.put(agent, result.get(agent) + amount);
}