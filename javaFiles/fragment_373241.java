String getOrDefault(JSONObject obj, String key, String defValue) {
     try {
         String value = obj.getString(key);
         return value;
     }
     catch (Exception ex) {
         return defValue;
     }
}

// similary create functions for all data types.