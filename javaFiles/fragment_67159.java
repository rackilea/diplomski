import java.util.ArrayList;
public class Go {
    public static void main(String[] args) {
        // running below creates an ArrayList<Ansat> that is inside KlasseObject
        Data klasseObject = new Data();

        // creates one Ansat(Hey,123) and add it to list
        klasseObject.setData("Hey", 123);

        // creates one Ansat(Raf,555) and add it to list
        klasseObject.setData("Raf", 555);

        // creates one Ansat(X-men,999) and add it to list
        klasseObject.setData("X-men", 999);

        //as many classes as you want, it would add them all to the list
        //of klasseObject 

        // now that we set three Ansats, we will retrieve the list and print
        // them all
        for (Ansat s : klasseObject.getAnsatList())
            System.out.println(s.toString());
    }
}

class Ansat {
    public String navn;
    public int alder;

    //remove the array list from constructor, not needed
    public Ansat(String navn, int alder) {
        this.navn = navn;
        this.alder = alder;
    }

    public int getAlder() {
        return alder;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    //overrided toString method to pretty-print Ansat object
    public String toString() {
        return navn + " , " + alder;
    }
}

class Data {
    private ArrayList<Ansat> ansat;

    // added the constructor for Data to initialize Data with empty list
    public Data() {
        ansat = new ArrayList<Ansat>();
    }

    //replaced infoListe to setData and added args to it so you can 
    //pass them from main method
    public void setData(String name, int age) {
        // every time setData is called a new Ansat is added to list
        Ansat a = new Ansat(name, age);
        ansat.add(a);
    }

    public ArrayList<Ansat> getAnsatList() {
        return ansat;
    }
}