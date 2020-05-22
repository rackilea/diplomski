public static void main (String[] args)
{
    HashMap<String, Integer> stats = new HashMap<String,Integer>();
    stats.put("x",3);
    stats.put("y",4);
    stats.put("z",5);
    stats.put("b",9);
    HashMap<String, Integer> statsCopy = new HashMap<String,Integer>();

    statsCopy.putAll(stats);//this will copy all the values from the base object
}