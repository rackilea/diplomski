List<String> list = new ArrayList<String>();
StringTokenizer st = new StringTokenizer(line, ":Mode set - Out of Service In Service");
while(st.hasMoreTokens()){
  // out.println(st.nextToken());
  list.add(st.nextToken());
}