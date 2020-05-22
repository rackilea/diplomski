try 
{
if(!test1.matches("(d+)(p/)(d+)"))
     throw new NumberFormatException();
}
catch (NumberFormatException e) 
{
JOptionPane.showMessageDialog(null, e.getMessage(), "ALERT!", JOptionPane.ERROR_MESSAGE);   
}