List<List<Object>> merged = new ArrayList<>();    
for (int i = 0; i < Names.size(); i++) {
      List<Object> temp = new ArrayList<>();
      temp.add(Names.get(i));
      temp.add(Values.get(i));
      merged.add(temp);
}