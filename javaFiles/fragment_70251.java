public class Vehicle {

    enum TipoVeicolo {
        AUTO, FURGONE,
        AUTOCARRO,
        AUTOARTICOLATO
    };

    private String targa;
    private TipoVeicolo tipoVeicolo;
    private String marca;
    private Stato stato
    private float ptt;
    //... others...

    // constructor
    public Vehicle(String targa, TipoVeicolo tipoVeicolo, String marca, Stato stato, float ptt) {
        this.targa=targa;
        this.tipoVeicolo=tipoVeicolo;
        // ... bla bla
    }

    // GET and SET methods...
    //...
}