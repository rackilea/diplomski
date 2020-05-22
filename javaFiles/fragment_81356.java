for (int x = 0; x < root.getAsJsonArray().size(); x++) {
  rootObj = rootArr.get(x).getAsJsonObject();
   int i=0;
  for (String attribute : attributes) {

    for (String value : values) {
      if (rootObj.get(attribute).getAsString().equals(value)) {
           i++;
      }
    }
  }
   if(i==2){
      results.add(rootObj);
    }
}
return results;