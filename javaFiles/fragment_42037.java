public Map toMap() {
     HashMap<String, String> serviceAsMap = new HashMap<>();
     servicesAsMap.put("serviceName", serviceName);
     servicesAsMap.put("className", this.class.getName() + ".class");
     servicesAsMap.put("isEnabled", isEnabled);
     // ... continue for all values
     return servicesAsMap;
 }