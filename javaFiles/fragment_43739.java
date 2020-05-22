private int findFirstNull(String[] array) {
  for(int i=0; i<r.length; i++)
    if(r[i] == null)
      return i;
  return -1;
}