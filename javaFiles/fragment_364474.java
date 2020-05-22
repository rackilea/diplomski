else if (jsonElement1.isJsonArray() && jsonElement2.isJsonArray()) {
    JsonArray jarr1 = jsonElement1.getAsJsonArray();
    JsonArray jarr2 = jsonElement2.getAsJsonArray();
    if (jarr1.size() != jarr2.size()) {
      return false;
    } else {
      // Iterate JSON Array to JSON Elements
      for (JsonElement je1 : jarr1) {
        boolean flag = false;
        for(JsonElement je2 : jarr2){
         flag = compareJson(je1, je2);
         if(flag){
          jarr2.remove(je2);
          break; 
         }
        }
        isEqual = isEqual && flag;
      }
    }
  }