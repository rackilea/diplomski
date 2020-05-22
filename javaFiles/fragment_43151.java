import javax.swing.*;

public class AverageNumbers {

    public static void main(String[] args) 
    {           
            int data = 0;
            int positive = 0;
            int negative = 0;
            int count = 0;
            int total = 0;
            double avg = 0;


            String strdata = JOptionPane.showInputDialog ("Enter the integer The input ends if the value is 0")  ;
            data = Integer.parseInt(strdata);

            while (data !=0) 
            {
                if (data >0) {
                    positive++;
                } else { 
                    negative++;
                }                    
                total = total + data;
                count++;

                strdata = JOptionPane.showInputDialog ("Enter the integer The input ends if the value is 0")  ;
                data = Integer.parseInt(strdata);
            }


            String strOutput = "The number of positives is  " + positive;
            JOptionPane.showMessageDialog(null, strOutput);
            strOutput = "The number of negatives is  " + negative;
            JOptionPane.showMessageDialog(null, strOutput);
            strOutput = "The number of total is " + count ;
            JOptionPane.showMessageDialog(null, strOutput);
            avg = total * 1.0 /count ;
            strOutput = "The number of average is " + avg;
            JOptionPane.showMessageDialog(null, strOutput);
            System.exit(0);
    }
}