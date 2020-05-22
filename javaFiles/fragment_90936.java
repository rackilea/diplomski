public class Methods {

    private Country country;
    private ArrayList<Country> overview = new ArrayList<Country>();
    private ArrayList<Country> overviewSorted = new ArrayList<Country>();
    int [] test;

    public void regCountry(String countryname, int numbers){
        if(!(countryname == "" && numbers == 0)){
            overview.add(new Country(countryname, numbers));
        } else {
            System.out.println("The input was null");
        }
    }

    public void showRegisteredCountries(){
        if(!(overview.size() < 0)){
            for(int i = 0; i < overview.size(); i++){
                System.out.println("The country: " + overview.get(i).getCountryName() + " has the number: " + overview.get(i).getNumber() + " registered");
            }
        } else {
            System.out.println("There are no country registered");
        }
    }

    public void numbersOverFromArrayList(){
        if(!(overview.size() < 0)){
            test = new int [overview.size()];
            for(int i = 0; i < overview.size(); i++){
                test[i] = overview.get(i).getNumber();
            }
        }
    }

    public void sortArrayAndCopyItBack(){
        if(!(test.length < 0)){
            java.util.Arrays.sort(test);
            for(int i = 0; i < test.length; i ++){
                for(int j = 0; j < overview.size(); j++){
                    if(test[i] == overview.get(j).getNumber()){
                        overviewSorted.add(new Country(overview.get(j).getCountryName(), overview.get(j).getNumber()));
                    }
                }
            }
        }
    }

    public void showTableSorted(){
        if(!(overviewSorted.size() < 0)){
            for(int i = 0; i < overviewSorted.size(); i++){
                System.out.println("Country name: " +     overviewSorted.get(i).getCountryName() + " with number: " +     overviewSorted.get(i).getNumber());
            }
        } else {
            System.out.println("There are non countrys in table that is sorted");
        }
    }


}