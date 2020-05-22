public class Color {

    public String color;
    public Color (String color) {
        this.color = color;
    }
    public static Color grey = new Color("grey");
}

public class car {

    int PS;
    Color color;

    public car (int PS, Color color) {
        this.PS = PS;
        this.color = color;
    }

    public static void main (String args[]) {
        car myCar = new car(80, Color.grey);
    }
}