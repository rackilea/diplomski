List<String> userList = new ArrayList<String>(Arrays.asList("ann", "john", "tim", "ann"));
    List<Integer> timeList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 5));

    Map<String, Integer> userTimeMap = new HashMap<String, Integer>();
    for (int i = 0; i < userList.size(); i++) {
        String user = userList.get(i);
        Integer time = userTimeMap.get(user);
        if (time == null) {
            userTimeMap.put(user, timeList.get(i));
        } else {
            userTimeMap.put(user, time + timeList.get(i));
        }
    }