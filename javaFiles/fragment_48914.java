public int getKey(String s){
 int [] arr=countLetters(s);
 int maxDex=indexOfMax(arr);
 int key;
 if (maxDex<4) key= maxDex-4+26;
 else key=maxDex-4;
 return key;
 }