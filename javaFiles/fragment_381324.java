package de.scrum_master.feature1.prv;

import de.scrum_master.feature2.prv.Feature2Private;
import de.scrum_master.feature2.pub.Feature2Public;

public class Feature1Private {
    private int id;
    private String name;

    public Feature1Private(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        new Feature2Private(11111, "This should be illegal");
        new Feature2Public(22222, "This should be OK");
        return "Feature1Private [id=" + id + ", name=" + name + "]";
    }
}