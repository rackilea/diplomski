@Override
public boolean equals(Object obj) {
   if (obj instanceof JSONObject) {
      return myHashMap.equals(((JSONObject)obj).myHashMap);
   } else {
      return false;
   }
}