package de.scrum_master.feature2.prv;

import de.scrum_master.feature1.prv.Feature1Private;
import de.scrum_master.feature1.pub.Feature1Public;

public class Feature2Private {
    private int id;
    private String name;

    public Feature2Private(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        new Feature1Private(33333, "This should be illegal");
        new Feature1Public(44444, "This should be OK");
        return "Feature2Private [id=" + id + ", name=" + name + "]";
    }
}