int charCode;
String k = "";
String b = JOptionPane.showInputDialog(null,"Enter binary");
while (b.length > 8) {
    charCode = Integer.parseInt(b.substring(0, 8),2);
    k += new Character((char)charCode).toString();
    b = b.substring(8);
}
if (b.length() > 0) {
    //attempt handle any trailing bits that might be left
    charCode = Integer.parseInt(b,2);
    k += new Character((char)charCode).toString();
}

JOptionPane.showMessageDialog(null,k);