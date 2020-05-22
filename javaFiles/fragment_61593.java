HashMap map = new HashMap();

  map.put("1","2");
  map.put("2","1");
  map.put("3","8");
  map.put("4","4");
  map.put("5","6");
  map.put("6","8");
  map.put("7","3");
  map.put("8","4");
  map.put("9","4");

  HashMap dups = getDuplicateValues(map);

  System.out.println("MAP = "+map);
  System.out.println("DUP = "+dups);