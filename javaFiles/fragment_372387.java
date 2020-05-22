238 public String getLimitString(String sql, boolean hasOffset) {
239     return new StringBuffer( sql.length()+20 )
240         .append(sql)
241         .append( hasOffset ? " limit ?, ?" : " limit ?")
242         .toString();
243 }