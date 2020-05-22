while(rs.next()){
     for(int i=1;i<columnNumber;i++){
         inner.add(rs.getString(i));
     }
     outer.add(inner);
   }