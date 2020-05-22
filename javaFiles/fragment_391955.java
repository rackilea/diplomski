public String determineMessage() {
    String msg = "Forecast Display: ";
    if (currentPressure > lastPressure) {
        msg += "Improving weather on the way!";
    } else if (currentPressure == lastPressure) {
        msg += "More of the same";
    } else if (currentPressure < lastPressure) {
        msg += "Watch out for cooler, rainy weather";
    return msg;
 }

public void display() {
    System.out.println(determineMessage());
}