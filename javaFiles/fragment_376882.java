//the result
 char [][]a = new char[5][5];
 //the alphabet
 char [] alphabet = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','X','Y','Z'};
 //the key
 String key = "LACOR";
 //use count as effective index of the array
 int count = 0;
 //fill the result with the key
 for(;count<key.length();count++){
     a[count/5][count%5]=key.charAt(count);
 }
 //fill the rest of the array with alphabet - key
 for(int i = 0;i<alphabet.length;i++){
     if(!key.contains(""+alphabet[i])){
         a[count/5][count%5]=alphabet[i];
         count++;
     }
 }
 //print the result
 System.out.println(Arrays.deepToString(a));