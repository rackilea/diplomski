public Hund(String namn , int ålder , int vikt, String ras) {
    this.namn = namn;
    this.ålder = ålder;
    this.vikt = vikt;
    this.ras = ras;
    // Set the length of the tail
    if(ras.equalsIgnoreCase("tax")) {
        svanslängd = 3.7;
    }else{
        svanslängd = (ålder * vikt)/10.0;
    }
}