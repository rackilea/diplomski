List<Map.Entry<Integer, Float>> list = new ArrayList<>(map.entrySet());
Collections.sort(list, new Comparator<Map.Entry<Integer, Float>>() {
  public int compare(Map.Entry<Integer, Float> e1, Map.Entry<Integer, Float> e2){
    return e1.getValue().compareTo(e2.getValue());
  }
});