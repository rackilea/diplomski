public void mulBy2(List<Number> list) {
    for (int i = 0; i < list.size(); i++) {
      Double d =  list.get(i).doubleValue()*2;
      list.set(i,d);
    }
}