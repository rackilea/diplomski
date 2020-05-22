public static double[] getAmount()
{
  int MAX_NUM = 10;
  double[] numArray = new double[MAX_NUM];
  int i = 0;
  while (i < numArray.length)
  {
     double numInput;

        try
        {
           numInput = Double.parseDouble(JOptionPane.showInputDialog("Enter amounts in $: "));
        }
        catch (NumberFormatException e)
        {
           numInput = MAX_NUM - 11;
        }
        if (numInput < 0 || numInput > 999999)
        {
           JOptionPane.showMessageDialog(null, "Error. Please enter valid amount in dollars");
           numInput = Double.parseDouble(JOptionPane.showInputDialog("Enter amount in $: "));
        }
        else
        {
           numArray[i] = numInput;
           i++;
        }
   }

   return numArray;
}