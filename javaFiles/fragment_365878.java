HashMap<String,HashMap<String, ArrayList<HashMap<String, String>>>> 
      data = new HashMap<>();
    HashMap<String, ArrayList<HashMap<String,String>>> 
      map2 = new HashMap<String, ArrayList<HashMap<String,String>>>();
    data.put(user, map2);
    map2.put(info, new ArrayList<HashMap<String, String>>());