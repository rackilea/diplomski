public static String parseTableName(String s) {                             
  Pattern p = Pattern.compile("Table name=([^,]*)");                        
  Matcher m = p.matcher(s);                                                 
  return m.find() ? m.group(1) : null;                                      
}                                                                           

// ...
parseTableName(yourString); // => "test_table"