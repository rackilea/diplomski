if(myMap.containsKey("1")){
         myMap.put("1", myMap.get("1").add(new Record()));//record obj
      }else{
         List<Record> list = new ArrayList<>();
         list.add(record);
         myMap.put("1", list));
     }