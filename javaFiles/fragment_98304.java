while (res.next()) {              
   row = new Vector(c);
   for(int i=1; i<=c; i++){
   row.add(res.getString(i));
   }
   data.add(row);
   }