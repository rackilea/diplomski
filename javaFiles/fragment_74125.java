public List<Object> getKeysFromValue(Map<?, ?> hm, Object value){
    List <Object>list = new ArrayList<Object>();
    for(Object o:hm.keySet()){
        if(hm.get(o).equals(value)) {
            list.add(o);
        }
    }
    return list;
  }