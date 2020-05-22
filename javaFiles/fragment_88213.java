public class CalculatePercent {

    private int numberGiven;
    private int finalPerc;

    public String numberGiven(int numberGiven) {
        this.numberGiven = numberGiven;
        if (this.numberGiven <= 100) {
            finalPerc = 5;
        } else if (this.numberGiven > 100) {
            finalPerc = 5 * (this.numberGiven - 99);
            /*
                Why 99 ?
                For examaple :
                100 - 99 = 1 * 5 = 5%;
                101 - 99 = 2 * 5 = 10%;
                102 - 99 = 3 * 5 = 15%
                soon
            */
        }
        return "The percentage" + " " + "is:" + " " + finalPerc + "%";
    }
}