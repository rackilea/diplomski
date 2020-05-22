class Sample {
     private String foo;
     private String bar;

     private Map<String, Map<String, Object>> data = new LinkedHashMap<>();

     @JsonAnyGetter
     public Map<String, Map<String, Object>> getData() {
          return data;
     }

     @JsonAnySetter
     public void set(String key, Map<String, Object>) {
          data.put(key, object);
     }
}