StringBuilder builder = new StringBuilder();
builder.add("INSERT INTO table (");
for(int i=0; i<rows.length: rows){
   builder.add(row);
   if(i<rows.length -1){
      builder.add(",")
   }
}
builder.add(") VALUES (");
....