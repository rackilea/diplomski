StringBuilder sb=new StringBuilder();
sb.append("CREATE TABLE " + table + " ( ");

 for (int i = 0; i < values.length; i++) {
   sb.append(values[i]);
   if (i >= values.length-1) {break;}
  sb.append(",");
 }
 sb.append(" )");
 state.execute(sb.toString());