public class Vehicle {
    protected String immat;
    protected int poidsVide;
    protected int charge;
    protected static final int CHARGE_MAX = 10000; // this is a constant

    Vehicle(String immat, int poidsVide, int charge) {
        this.immat = immat;
        this.poidsVide = poidsVide;

        if (charge > CHARGE_MAX){
          this.charge = CHARGE_MAX;
        }
        else {
          this.charge = charge;
        }
    }

}