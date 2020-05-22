public int nextInt(int[] s){
  if(s!=null && s.length > 3){
    if( s[1] - s[0] == s[2] - s[1] ) return ( s[1] - s[0] ) + s[s.length - 1];
    if( s[1] / s[0] == s[2] / s[1] ) return ( s[1] / s[0] ) * s[s.length - 1];
  }
  return -1;
}