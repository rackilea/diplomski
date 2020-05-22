public class FareStorage {
    Map<TownCombination, Double> fares;

    //...

    public double getFare(String townA, String townB) {
        return fares.get(new TownCombination(townA, townB));
    }

    public void addFare(String townA, String townB, double fare) {
        fares.put(new TownCombination(townA, townB));
    }

    class TownCombination {
        String town1;
        String town2;

        //If a fare from A to B is equals the fare from B to A, 
        //then the A-B and the B-A combinations should be equal. 
        //Override hashCode and equals the way you want.  
    }
}