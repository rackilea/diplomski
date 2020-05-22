Map<String, List<Rows>> map = new HashMap<String, List<Rows>>()
 while( rs.next() ) {
      Rows row = new Rows();
      /*
       * code to initialize the values of row from the record
       */
      String category = rs.getString("Cat");
      if(!map.containsKey(category)){
            map.put(category, new ArrayList<Rows>());
      }
      map.get(category).add(row);
  }