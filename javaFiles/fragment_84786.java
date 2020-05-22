Course c;
    while(rs.next()){
        c = new Course(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getBytes("img"),
                        rs.getString("description")
                       );
      // this line below should be added
      list.add(c)
    }