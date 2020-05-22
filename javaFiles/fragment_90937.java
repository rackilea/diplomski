public class test2 {
    public static void main(String [] args){

        Methods methodes = new Methods();

        for(int i = 0; i < 4; i++){
        String inCountry = JOptionPane.showInputDialog("Country:");
        String inNumber = JOptionPane.showInputDialog("number:");
        String country = inCountry;
        int number = Integer.parseInt(inNumber);
        methodes.regCountry(country, number);
        }

        methodes.showRegisteredCountries();
        methodes.numbersOverFromArrayList();
        methodes.sortArrayAndCopyItBack();
        methodes.showTableSorted();
    }
}