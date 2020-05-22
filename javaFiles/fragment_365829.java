abstract class CoffeeSize {
    CoffeeSize(int ounces) {
        this.ounces = ounces;
    }

    private int ounces;

    public int getOunces() {
        return ounces;
    }

    public String getLidCode() {
        return "B";
    }
}

CoffeeSize OVERWHELMING = new CoffeeSize(3) {
    @Override
    public String getLidCode() {
        return "A";
    }
};