// create variables for the container of values from the AnalyseZin
int newIntVal = 0;
ArrayList<String> newListVal = new ArrayList<String>();

// create instance of the object
AnalyseZin test = new AnalyseZin();
// call woordenNaarLijst method to update the woorden and aantalWoorden
test.woordenNaarLijst();

// pass values from AnalyseZin
newIntVal = test.getAantalWoorden
newListVal = test.getWoorden();

// print out int values
System.out.println("new int value = " + Integer.toString(newIntVal));
// print out list contents
for (String item : newListVal){
    System.out.println("item from list = " + item);
}