pstmt = con.prepareStatement(QueryIn);

while(it.hasNext()) {
  String value = it.next().toString(); 

  StringTokenizer strTok = new StringTokenizer(value,splitter);
  String S = strTok.nextElement().toString().trim();
  String I = strTok.nextElement().toString().trim();                
  String M = strTok.nextElement().toString().trim();
  String d = strTok.nextElement().toString();               
  String R = strTok.nextElement().toString().trim();                
  String Pu = strTok.nextElement().toString().trim();

  // pstmt=con.prepareStatement(QueryIn);
  // ...