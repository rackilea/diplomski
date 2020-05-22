/**
 * Method for printing unoccupied property of the class LettingAgent.
 */
public void printListOfUnoccupiedProperty(char Location, double maxmonthlyRent, int miniNoBeds) {
    // initialise instance variables
    for (Property Property : agproperty) {
        if ((Property.getLocation().equals(Location))
                && (Property.get(monthlyRent).equals(maxmonthlyRent))
                && (agproperty.get(numberOfBedrooms).equals(miniNoBeds))) {
            System.out.Println(Propnumber);
            Property.printProperty();
        } else {
            System.out.println("The Property number is not valid");
        }
    }
}