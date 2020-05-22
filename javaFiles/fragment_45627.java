import java.text.DecimalFormat;

import javax.swing.*;

public class ArrayWithException 
{
        static  int ctr = 0;
        public static void main(String[] args)
        {
            String inputStr = "";
            double num2process = 0.0;
            double sum = 0.0, ave = 0.0;
            double[] grade ;

            while(true)
            {
                try
                {
                    inputStr = JOptionPane.showInputDialog("Enter number of subjects to enter: ");
                    num2process = Double.parseDouble(inputStr);
                    grade = new double[(int) num2process];
                    marks = new double[(int) num2process];
                    while(ctr<num2process)
                    {
                        grade[ctr] = getNumber();
                        sum += grade[ctr];
                        ctr++; 
                    }

                }
                catch (NumberFormatException err)
                {
                    JOptionPane.showMessageDialog(null, "There is an error on entry",
                        "Error Message", JOptionPane.WARNING_MESSAGE);
                    continue;
                }
                break;      

            }

            //accumulate the output
            String output="";
            int ctr2 = 0;

            output = "";

            while(ctr2 > num2process)
            {
                output +=("Grade on subject " +(ctr2+1) + " is "
                                + grade[ctr]);
                ctr2++;

            }

            ave = sum / num2process;
            DecimalFormat df=new DecimalFormat("##.##");   //Here it defines the pattern to follow
            ave=Double.parseDouble(df.format(ave));        //ave is formatted like df
            output +="\nAverage is " + ave;
            for(int i=0;i<grade.length;i++){ 
                output+="\nGrade for Subject "+(i+1)+" is: "+grade[i];
            }

            // display the output

            JOptionPane.showMessageDialog(null,output, "The result is",
                        JOptionPane.INFORMATION_MESSAGE);

        }

        public static int getNumber() throws NumberFormatException
        {
            String inputStr="";
            int num = 0;

            try
            {
                inputStr = JOptionPane.showInputDialog("Enter grade on subject " + (ctr+1));
                num = Integer.parseInt(inputStr);

                return num;

            }
            catch (NumberFormatException errorAgain)
            {
                throw errorAgain;
            }
        }
}