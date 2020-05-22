String message = "" ;
String m = "";
for(int i = 0; i < 8; i++)
{
    message = message + m + "\n";
    m = m + "*";
}
JOptionPane.showMessageDialog(null, message);