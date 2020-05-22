Map map = new HashMap()
 for( Row row : resultset ) {
      if(!map.containsKey(row.category)){
            map.put(row.category, new ArrayList());
      }
      map.get(row.category).add(row.name);
  }