package de.scrum_master.app;

import de.scrum_master.aspect.Marker;

public class Application {
    @Marker
    public static void foo() {}

    public static void bar() {}

    @Marker
    public static void zot() {}

    public static void main(String[] args) {
        foo();
        bar();
        zot();
    }
}