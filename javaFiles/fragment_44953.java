public class Dvd {
    private String dvdTitle;
    private String dvdDirector;
    private String dvdLead;
    private double dvdRunTime;
    private float dvdPrice;

    public Dvd() {
        dvdTitle = "";
        dvdDirector = "";
        dvdLead = "";
        dvdRunTime = 0;
        dvdPrice = 0;
    }

    public void getInputs() {
        System.out.println("Please enter the Dvd Title: ");
        dvdTitle = Genio.getString();

        System.out.println("Please enter the Dvd Director: ");
        dvdDirector = Genio.getString();

        System.out.println("Please enter the Dvd Lead Actor/Actress: ");
        dvdLead = Genio.getString();

        System.out.println("Please enter the Dvd Run Time: ");
        dvdRunTime = Genio.getDouble();

        System.out.println("Please enter the Dvd Cost: ");
        dvdPrice = Genio.getFloat();
    }

    public String getTitle() {
        return dvdTitle;
    }

    public String getDirector() {
        return dvdDirector;
    }

    public String getLead() {
        return dvdLead;
    }

    public double getRunTime() {
        return dvdRunTime;
    }

    public float getDvdPrice() {
        return dvdPrice;
    }
}