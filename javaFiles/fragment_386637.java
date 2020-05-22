package tessty;

public abstract class Item {

    int weight;

    public static class Apple extends Item {
        public Apple() {
            weight = 2;
        }
    }

    public static class Shoe extends Item {
        public Shoe() {
            weight = 3;
        }
    }

}