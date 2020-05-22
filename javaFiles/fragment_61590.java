ArrayList al = new ArrayList();    
while(rs.next){
         Bean b = new Bean();
         b.col1(rs.getString(1));
         b.col2(rs.getString(2));
         if(rs.getString(3))
              b.DT_RowClass = "class1";
         else
              b.DT_RowClass = "class2";
         al.add(b);
    }