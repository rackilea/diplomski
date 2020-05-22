private static Map> nameMap = new HashMap>();

    private static void splitEmUp(final List names)
    {
        for (String current : names)
        {
            List listaly;
            String[] splitaly = current.split("_|\\.");

            listaly = nameMap.get(splitaly[1]);
            if (listaly == null)
            {
                listaly = new LinkedList();
                nameMap.put(splitaly[1], listaly);
            }

            listaly.add(current);
        }