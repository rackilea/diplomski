package de.scrum_master.common.prv;

public class CommonPrivate {
    private int id;
    private String name;

    public CommonPrivate(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "CommonPrivate [id=" + id + ", name=" + name + "]";
    }
}