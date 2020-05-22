public class Term {
   private String mName = "";
   private Map<String, Integer> mPropertyMap = new LinkedHashMap<String, Integer>();
   private List<String> mEntitiesList = new ArrayList<String>();

   public Term(String name) {
       mName = name;
   }

   public void generate(Map<String, Integer> propertyMap,   List<String> entitiesList) {
    mPropertyMap = propertyMap;
    mEntitiesList = entitiesList;
   }

  public Map<String, Integer> getPropertyMap() {
    return mPropertyMap;
}

public void setPropertyMap(Map<String, Integer> propertyMap) {
    this.mPropertyMap = propertyMap;
}

public List<String> getEntitiesList() {
    return mEntitiesList;
}

public void setEntitiesList(List<String> entitiesList) {
    this.mEntitiesList = entitiesList;
}

public String getName() {
    return mName;
}

public void setmName(String name) {
    this.mName = name;
}

}