import java.util.ArrayList;
import java.util.List;

public class Race {

    private int raceID;

    private double purity;

    private int strMod;

    private int dexMod;

    private int conMod;

    private int wisMod;

    public int getRaceID() {
        return raceID;
    }

    public void setRaceID(int raceID) {
        this.raceID = raceID;
    }

    public double getPurity() {
        return purity;
    }

    public void setPurity(double d) {
        this.purity = d;
    }

    public int getStrMod() {
        return strMod;
    }

    public void setStrMod(int strMod) {
        this.strMod = strMod;
    }

    public int getDexMod() {
        return dexMod;
    }

    public void setDexMod(int dexMod) {
        this.dexMod = dexMod;
    }

    public int getConMod() {
        return conMod;
    }

    public void setConMod(int conMod) {
        this.conMod = conMod;
    }

    public int getWisMod() {
        return wisMod;
    }

    public void setWisMod(int wisMod) {
        this.wisMod = wisMod;
    }

    @Override
    public String toString() {
        return "Race [raceID=" + raceID + ", purity=" + purity + ", strMod="
                + strMod + ", dexMod=" + dexMod + ", conMod=" + conMod
                + ", wisMod=" + wisMod + "]";
    }

    public static void main(String args[]) {

        //create a list of race objects
        List<Race> raceCollection = new ArrayList<Race>();

        //create a race object
        Race race = new Race();
        race.setRaceID(1);
        race.setPurity(0.75);
        race.setStrMod(5);
        race.setDexMod(7);
        race.setConMod(-2);
        race.setWisMod(3);

        //add race object to collection
        raceCollection.add(race);

        //You can create and add multiple objects of race to the collection


        //Iterate your list and print the objects
        for(Race raceObj:raceCollection) {
            System.out.println(raceObj);
        }


    }

}