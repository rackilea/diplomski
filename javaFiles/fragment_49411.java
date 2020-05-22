String msg = "http://100.15.111.60:80/";
char tokenSeparatpor = ':';
StringTokenizer st = new StringTokenizer(msg,tokenSeparatpor+"");
while(st.hasMoreTokens()){
    System.out.println(st.nextToken());
}