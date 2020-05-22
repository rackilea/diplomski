int numBmi = 0;
    int numBmr = 0;
    int numTdee = 0;

    try
    {

        BufferedReader bmi = new BufferedReader(new FileReader("bmi.txt"));

        while((line = bmi.readLine()) != null)
        {
            currentline = line;
        }
        lastline = currentline;
        rbmi.setText(lastline);
        try {
            numBmi = Integer.parseInt(lastline);
        } catch (Exception e) {
        } 
        bmi.close();

        BufferedReader bmr = new BufferedReader(new FileReader("bmr.txt"));

        while((line = bmr.readLine()) != null)
        {
            currentline = line;
        }
        lastline = currentline;
        rbmr.setText(lastline);
        try {
            numBmr = Integer.parseInt(lastline);
        } catch (Exception e) {
        } 
        bmr.close();

        BufferedReader tdee = new BufferedReader(new FileReader("tdee.txt"));

        while((line = tdee.readLine()) != null)
        {
            currentline = line;
        }
        lastline = currentline;
        rtdee.setText(lastline);
        try {
            numTdee = Integer.parseInt(lastline);
        } catch (Exception e) {
        } 
        tdee.close();           
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, "File does not exist", "Error", JOptionPane.ERROR_MESSAGE);
    }

    double calBmi = suggested(numBmi);
    double calBmr = suggested(numBmr);
    double calTdee = suggested(numTdee);
}

public static double suggested(double inputValue)
{
    double rate = inputValue * 0.15;
    double result = inputValue - rate;
    return result;
}