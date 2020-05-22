public class CategoryResultHandler implements ResultHandler {

  Map<Integer,String> inMap = new HashMap<Integer,String>(); 

  public Map<Integer, String> getIdNameMap() {
    return inMap;
  }

  @Override
  public void handleResult(ResultContext rc) {
    @SuppressWarnings("unchecked")
    Map<String,Object> m = (Map<String,Object>)rc.getResultObject();
    inMap.put((Integer)getFromMap(m, "id"), 
              (String)getFromMap(m, "name"));
  }

  // see note at bottom of answer as to why I include this method
  private Object getFromMap(Map<String, Object> map, String key) {
    if (map.containsKey(key.toLowerCase())) {
      return map.get(key.toLowerCase());
    } else {
      return map.get(key.toUpperCase());
    }
  }
}