class User {    

Map<String, Object> properties;

      Object getParameter(String key){
        return properties.get(key);
      }
      void addParameter(String key, Object value){
        properties.put(key, value);
      }

}