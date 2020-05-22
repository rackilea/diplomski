long num = 4342175383962075708L;
char[][] table = new char[8][8];
String bin1 = Long.toUnsignedString(num, 2);

while(bin1.length()<64){
  bin1="0"+bin1;
}
//Store the bits in the array
int i=0;
for(int j = 0; j < 8; j++){
    for(int z = 0; z < 8; z++){
        table[j][z] = bin1.charAt(i++);
    }
}
//Print the numbers
for(char[] m : table){
  for(char n : m){
    System.out.print(n);
  }
  System.out.println()
}