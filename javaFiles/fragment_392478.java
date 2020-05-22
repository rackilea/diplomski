public static void main(String[] args)  { 
System.out.println("HEX to Binary: ");
String[] stringHextoBinary = new String[HS.length]; //HS is the String Array for Hex           numbers that i save from last step

// creates the string builder, count, and declaration
StringBuilder builder = new StringBuilder();
int l = 0;
string binaryDigits;

// iterates through string array and appends to string that's being built
// (for whatever reason)
for(String s : HS) {
    builder.append(s);
    binaryDigits = HexToBinary(s);
    stringHextoBinary[l++] = binaryDigits;
    System.out.print(binaryDigits);
}

// transforms hex string to binary string without losing 0's
public static String HexToBinary(String Hex) {
    string toReturn = new BigInteger(Hex, 16).toString(2);
    return String.format("%" + (Hex.length*4) + "s", toReturn).replace(' ', '0')
}