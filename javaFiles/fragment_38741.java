int x;
String aa[][]= new String[2][2]; // create an matrix of size 2x2
aa[0]=a; // store the program arguments into the first row of aa 
x=aa[0].length; // store the length of aa[0] which is the same as a
for(int y=0;y<x;y++) // iterate over aa[0] which is the same as a
    System.out.print(" "+aa[0][y]);