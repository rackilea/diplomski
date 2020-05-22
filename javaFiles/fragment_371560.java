Map<MyClass.Key, String> data = (HashMap<MyClass.Key, String>) getData(); 
  StringBuffer sb = new StringBuffer();
  for (Map.Entry<MyClass.Key,String> entry : data.entrySet()) {
       sb.append(entry.getKey());
       sb.append(": ");
       sb.append(entry.getValue());
   }
   return sb.toString();