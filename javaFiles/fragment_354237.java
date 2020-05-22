public static void main(String args[])
{
    Map<Integer, Integer> ht = new HashMap<Integer, Integer>();
    Map<Integer, Integer> ht2 = new HashMap<Integer, Integer>();
    for(int i=0;i<100;i++)
    {
        ht.put(i, i);
    }
    for(int i=50;i<100;i++)
    {
        ht2.put(i, i);
    }

    System.out.println("The following keys and values match:");

    for (Map.Entry<Integer, Integer> htEntries : ht.entrySet()) {
        if(ht2.containsKey(htEntries.getKey()) && ht2.get(htEntries.getKey()).equals(htEntries.getValue())){
            System.out.println("\tKey: " + htEntries.getKey() + " Value: " + htEntries.getValue());
        }
    }
}