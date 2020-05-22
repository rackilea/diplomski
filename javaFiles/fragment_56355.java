public class numberOfYears {
    public static void main(String args[]){
    String minsString = JOptionPane.showInputDialog("Enter numbers of minutes:");
    double mins = Double.parseDouble(minsString);
   //calcuate mins in a year
    double minsOfaYear = 365*24*60;
    double year = mins / minsOfaYear;
    double day = (mins % minsOfaYear)/(24*60);
    System.out.println((int)year+ " years and " + (int)day + " days");
    }
}