HashMap<String,HashMap<String, Object>> mapItem= new HashMap<String,HashMap<String,Object>>(); 

   if(!mapItem.containsKey(word.text)){
        HashMap<String, Object> map = new HashMap<String, Object>(); 
        map.put("ItemImage", R.drawable.speak2);
        map.put("ItemTitle", word.text);  
        map.put("ItemText", temp);  
        mapItem.put(word.text, map); 
    }