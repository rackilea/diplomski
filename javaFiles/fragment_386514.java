int find(List<String> l, String str){
  for(int i = 0, String s: l, i++)
    if (s.equals(str)) return i;
  return -1;
}
int ind;
if ((ind = find(testArr, "some")) != -1)
  testArr.set(ind, "other")