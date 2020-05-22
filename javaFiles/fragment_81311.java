public class Item {
    private int something;
    private String fruitName;
    private int numberOfFruits;

    public Item(int something, String fruitName, int numberOfFruits) {
        this.something = something;
        this.fruitName = fruitName;
        this.numberOfFruits = numberOfFruits;
    }

    public int getSomething() {
        return this.something;
    }

    public String getFruitName() {
        return this.fruitName;
    }

    public int getNumberOfFruits() {
        return this.numberOfFruits;
    }
}