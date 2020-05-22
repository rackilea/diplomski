private void pick_highest_value_here_and_display(ArrayList<Double> value) throws Exception {
             // TODO Auto-generated method stub
             double aa[]=value.stream().mapToDouble(v -> v.doubleValue()).toArray(); 
             double highest=aa[0]; 
              for(int i=1;i<aa.length;i++)
             {
                 if(aa[i]>highest)
                 {
                     highest=aa[i];
                     System.out.println(highest);
                     String sql ="Select * from placeseen where ID =?";
                     DatabaseConnection db = new DatabaseConnection();
                     Connection  conn =db.getConnection();
                     PreparedStatement  ps = conn.prepareStatement(sql);
                     ps.setDouble(1, i); 
                     ResultSet rs = ps.executeQuery();
                     if (rs.next()) 
                     {  
                      String aaa=rs.getString("place1");  
                      String bbb=rs.getString("place2");
                      String cc=rs.getString("place3");
                      Tourism to =new Tourism();
                      to.setPlace1(aaa);
                      to.setPlace2(bbb);
                      to.setPlace3(cc);
                      DispDay dc=new DispDay();
                      dc.setVisible(true);
                     }
                     ps.close();
                     rs.close();
                     conn.close();
             }  
                 else if(highest==aa[0])
                 {
                     String sql ="Select * from placeseen where ID =0";
                     DatabaseConnection db = new DatabaseConnection();
                     Connection  conn =db.getConnection();
                     PreparedStatement  ps = conn.prepareStatement(sql);

                     ResultSet rs = ps.executeQuery();
                     if (rs.next()) 
                     {  
                      String aaa=rs.getString("place1");  
                      String bbb=rs.getString("place2");
                      String cc=rs.getString("place3");
                      Tourism to =new Tourism();
                      to.setPlace1(aaa);
                      to.setPlace2(bbb);
                      to.setPlace3(cc);
                      DispDay dc=new DispDay();
                      dc.setVisible(true);
                     }
                     ps.close();
                     rs.close();
                     conn.close();
                 }


         }


             }