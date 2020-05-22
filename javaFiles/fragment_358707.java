String b = new String(in.nextLine());
char[] bCharArray = b.toCharArray();
for (int i = 0; i < n - 2; i++) {
    if(bCharArray[i] == '0' && bCharArray[i+1] == '1' && bCharArray[i+2] == '0')
   {
     bCharArray[i+2] = '1';
   }
}