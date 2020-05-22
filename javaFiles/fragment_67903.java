GaussianGenerator num = new GaussianGenerator();//calling another class
CriminalDetails() 
{
    initComponents();
    double number = 0;
    number = num.getNextValue();
    CriminalID.setText(Double.toString(number));//CriminalID jfield
}