Vehicle(String immat, int poidsVide, int charge) {
    this.immat = immat;
    this.poidsVide = poidsVide;

    if (charge > CHARGE_MAX){
      throw new IllegalArgumentException("Charge cannot be bigger than " + CHARGE_MAX);
    }
    else {
      this.charge = charge;
    }
}