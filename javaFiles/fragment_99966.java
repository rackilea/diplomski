inputTruth = false;
while(inputTruth == false)
{
identInput = JOptionPane.showInputDialog(null, "Please enter a student ID: ");
intID = Integer.parseInt(identInput);
savedIntID = Integer.parseInt(identInput);

for(x = 0; x < studentIDs.length; ++x)
{
    if(identInput.equals(studentIDs[x]))
    {
        JOptionPane.showMessageDialog(null, "The first name associated with \nStudent ID "
                + intID + " is: " + firstNames[x] + "\n" + firstNames[x] + "'s current GPA is: "
                + gPAs[x]);

        inputTruth = true;
        break;
    }
}

//The following will show up and continue to if the data is incorrect. Am not
//sure how to reuse if good data are entered.

if(inputTruth == false)
{
    JOptionPane.showInputDialog(null, "The Student ID you entered "
            + savedIntID + "\nis not valid. \nPlease enter another Student ID: ");
}
}