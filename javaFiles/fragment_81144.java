input = JOptionPane.showInputDialog(" What is the password please ?");
String inputPassWord = String.valueOf(input);

while (!inputPassWord.equalsIgnoreCase(passWord))
{
    input = JOptionPane.showInputDialog(" What is the password please ?");
    inputPassWord = String.valueOf(input);
}