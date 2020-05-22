HashMap<List<String>, Integer> masterList = 
      new HashMap<List<String>, Integer>();
...

ArrayList<String> tmp = (ArrayList<String>)currList.clone();
List<String> imm = Collections.unmodifiableList(tmp);
masterList.put(imm, imm.size());