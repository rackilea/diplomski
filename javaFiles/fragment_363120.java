TreeMap<Integer, Integer> bookMap = new TreeMap<Integer, Integer>();    
TreeMap<Integer, ArrayList<Integer>> userMap = new TreeMap<Integer, Integer>();

// for each line
  // read line and assign appropriate values to uid, libid, bid, year

  if (bookMap.get(bid) == null)
    bookMap.put(bid,year);

  if (userMap.get(uid) == null))
    userMap.put(uid, new ArrayList<Integer>());
  userMap.get(uid).add(bid);