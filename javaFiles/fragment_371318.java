public class PolynomialMember implements Comparable<PolynomialMember> {

    public int power; // public for brevity, but should be private with getters and setters
    public String number; // public for brevity, but should be private with getters and setters

    public PolynomialMember(String number, int power) {
        this.number = number;
        this.power = power;
    }

    @Override
    public int compareTo(PolynomialMember o) {
        return Integer.compare(this.power, o.power);
    }

    // optional: override for pretty printing
    @Override
    public String toString() {
        if(!number.equals("0")) {
            if(number.charAt(0) == '-') {
                return number + "x^" + power;
            } else {
                return "+" + number + "x^" + power;
            }
        } else {
            return "";
        }
    }
}