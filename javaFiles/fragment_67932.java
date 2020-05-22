public class WineChiller {

    double wineTemp;
    double preferredTemp;
    double chillTemp;

    public WineChiller(double wineTemp, double preferredTemp, double chillTemp) {
        this.wineTemp = wineTemp;
        this.preferredTemp = preferredTemp;
        this.chillTemp = chillTemp;

        getChillingTime();
    }