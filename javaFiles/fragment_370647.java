public String something() {
//over here I want to call a method for printing the blastTable in 
//JOptionPane( for example printArray).
//Having difficulties on creating a method containing a 
//two-dimensional array and how to call this method

//methode for creating blastTable, a grid of 8x8, 

int [][] blastTable = new int [8][8];

int lengteArray2 = blastTable [0].length;
int beginpunt = 32;
String a="";
for ( int x = 0; x < blastTable.length; x++) {
    for ( int y = 0; y < lengteArray2; y++){
                blastTable [x][y] = beginpunt;
                beginpunt--;
                a+=beginpunt+"  ";
    }
    a=a+"\n";
}
System.out.println(a);
return a;