class SearchParams {

   private Map<String, Object> values = new HashMap<>(); 

   public void setValue(String key, Object value) {
       this.values.put(key, value);
   }

   public Object getValue(String key) {
       this.values.get(key);
   }

   public Map<String, Object> list() {
       return new HashMap<>(this.values);
   }
}