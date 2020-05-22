Map<String,String> map=new HashMap<String,String>();  
  map.put("Shape1","Color1");  
  map.put("Shape2","Color2");  
  map.put("Shape3","Color3");  

  // Print output into console 
  for(Map.Entry m:map.entrySet()){  
   System.out.println(m.getKey()+" "+m.getValue());  
  }