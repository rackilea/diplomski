for(Map.Entry<String, List<String[]>> entry : Results.entrySet())
    {
        System.out.printf("[%s]\n",entry.getKey());
        for(String[] array : entry.getValue())
        {
            System.out.println(Arrays.toString(array));
        }
    }