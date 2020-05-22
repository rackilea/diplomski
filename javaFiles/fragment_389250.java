for(int i=0; i<list.size(); i++) {
  String s = list.get(i);
  int x = s.indexOf('(');
  if(x==-1) break;
  return s.substring(x+1);
}