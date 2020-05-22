int leftpos = 0, rightpos = 0;
List newlist = new ArrayList();
for(int pos = 0; pos < arr.length; pos++)
  if left[pos] < right[pos] newlist.add(left[leftpos++]);
    else newlist.add(right[rightpos++]);
return newlist;