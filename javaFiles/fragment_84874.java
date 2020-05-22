String[][] paths = {
        {"P", "B"}, 
        {"B", "M"},
        {"O", "P"},
        {"M", "Z"},
    };

    // create a single hash map, mapping start->end
    HashMap<String, String> end = new HashMap<>();

    for(int i = 0; i < paths.length; i++)
    {
        end.put(paths[i][0], paths[i][1]);
    }

    // find if a cycle exists
    String origin = null;
    for (String key : end.keySet()) {
        if(!end.containsValue(key))
        {
            origin = key;
            break;
        }
    }

    if(origin == null)
    {
        System.out.println("cycle exists");
        return;  // no origin found, cycle exists
    }

    // iterate over hash map:
    int count = 0;
    while(true)
    {
        if(!end.containsKey(origin))
            break;
        String next = end.get(origin);
        System.out.println(origin + " " + next);
        origin = next;
        if(++count > paths.length)
        {
            System.out.println("cycle exists");
            break;
        }
    }