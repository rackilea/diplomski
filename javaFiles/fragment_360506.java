public class Main {
    public static void main(String[] args) {
        Hamburger my_burger = new Hamburger("Hamburger");
        my_burger.select_items(
            100, // 100 lettuce
            0,   // 0 carrot
            2,   // 2 tomato
            1);  // 1 cheese
        my_burger.cal_price();
    }
}

public class Hamburger {
    private String name;
    private double base_price = 2.75;
    private int lettuce;
    private double lettuce_price = 0.50;
    private int carrot;
    private double carrots_price = 0.60;
    private int tomato;
    private double tomatos_price = 0.70;
    private int cheese;
    private double cheese_price = 0.85;

    public Hamburger(String name) {
        this.name = name;
    }

    public void select_items(int lettuce, int carrot, int tomato, int cheese) {
        this.lettuce = lettuce;
        this.carrot = carrot;
        this.tomato = tomato;
        this.cheese = cheese;
    }

    public void cal_price()
    {
        double final_price = getBase_price()
            + lettuce * lettuce_price
            + carrots * carrots_price
            + tomato * tomatos_price
            + cheese * cheese_price;
        // TODO print price
    }
}