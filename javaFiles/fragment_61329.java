public class AbstractModule {

    String kurzbezeichnung;

    public AbstractModule(String desc) {
        this.kurzbezeichnung = desc;
    }

    public String getKurzbezeichnung() {
        return this.kurzbezeichnung;
    }

}