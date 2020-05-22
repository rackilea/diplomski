while(true)
{
    String number = JOptionPane.showInputDialog("Enter Number");       

    if(number.length() >5 )
    {

        JOptionPane.showMessageDialog(null ,"Too Long! try again",JOptionPane.PLAIN_MESSAGE);
    }
    else break;
}