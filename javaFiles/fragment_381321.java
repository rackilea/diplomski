package de.scrum_master.common.pub;

import de.scrum_master.common.prv.CommonPrivate;
import de.scrum_master.feature1.prv.Feature1Private;
import de.scrum_master.feature1.pub.Feature1Public;
import de.scrum_master.feature2.prv.Feature2Private;
import de.scrum_master.feature2.pub.Feature2Public;

public class Application {
    private int id;
    private String name;

    public Application(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        System.out.println(new Application    (1, "Application"));
        System.out.println(new CommonPrivate  (2, "Common (private)"));
        System.out.println(new Feature1Public (3, "Feature 1 (public)"));
        System.out.println(new Feature1Private(4, "Feature 1 (private)"));
        System.out.println(new Feature2Public (5, "Feature 2 (public)"));
        System.out.println(new Feature2Private(6, "Feature 2 (private)"));
    }

    @Override
    public String toString() {
        return "Application [id=" + id + ", name=" + name + "]";
    }
}