public class qwixx {
    // declare the dice variables at the class level (as 'fields')
    dice white1;
    // same for other dice : declare them here

    public qwixx() {
        // in the constructor you actually create the object and assign references to the class variables
        white1 = new dice();
        // idem for others
    }
}