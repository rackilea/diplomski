public String[] fetchOptions() { 
      List<String> list = new ArrayList<String>();
      ... db code here
      while .... etc. et 
          list.add( rs.getString("product_name"));
      ... 
      // convert it to String[] 

     return list.toArray( new String[list.size()] );
 }