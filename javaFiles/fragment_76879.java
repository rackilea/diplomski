DefaultComboBoxModel list = new DefaultComboBoxModel();
JComboBox cbo_cats = new JComboBox(list);


// at constructor or a user-defined method that's called from constructor
   try{     
      // assume that all objects were all properly defined
      s = con.createStatement();
      s.executeQuery("SELECT * FROM cats ORDER BY catName");
      rs = s.getResultSet();
      while(rs.next()){
         //int id = rs.getInt("id");
         //list.addElement(id);

         String c = rs.getString("catName");
         list.addElement(c);
      }
   }catch(Exception err){
      System.out.println(err);
   }