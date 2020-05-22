Map<String,String> nameToType = new HashMap<String,String>();
  Map<String,Integer> nameToCount = new HashMap<String,Integer>();
  //fill Maps from file here
  Map<String,Integer> result = new HashMap<String,Integer>();
  for (String name: nameToType.keyset())
  {
        String type = nameToType.get(name);
        int count = nameToCount.get(type);

        if (!result.containsKey(type))
            result.put(type,0);
        result.put(type, result.get(type) + count);
   }