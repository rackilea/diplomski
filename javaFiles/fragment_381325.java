package de.scrum_master.feature2.pub;

public class Feature2Public {
    private int id;
    private String name;

    public Feature2Public(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Feature2Public [id=" + id + ", name=" + name + "]";
    }
}