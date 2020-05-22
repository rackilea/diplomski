package de.scrum_master.feature1.pub;

public class Feature1Public {
    private int id;
    private String name;

    public Feature1Public(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Feature1Public [id=" + id + ", name=" + name + "]";
    }
}