for (Map.Entry<String, ArrayList<String[]>> entry : hashTableForWorld.entrySet()) {
    String key = entry.getKey();
    ArrayList<String[]> value = entry.getValue();

    System.out.println ("Key: " + key + " Value: ");
    for(int i = 0; i < value.size(); i++)
    {
        System.out.print("Array " + i + ": ");
        for(String val : value.get(i))
            System.out.print(val + " :: ")
        System.out.println();
    }
}