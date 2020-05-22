package de.professional_webworkx.model.entities;

public class Item {

    private String name;
    private double price;
    private int count;

    public Item() {
        super();
    }

    public Item(String name, double price, int count) {
        super();
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}