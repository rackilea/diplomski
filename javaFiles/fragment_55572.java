package org.stackoverflow;

import java.util.ArrayList;

public class Example {

    public static class MyObject {

        private double value;

        public MyObject(double value) {
            this.setValue(value);
        }

        public final void setValue(double value) {
            this.value = value;
        }

        public double getValue() {
            return this.value;
        }

    }

    public static void main(String[] args) {
        long start = 0;
        ArrayList<MyObject> objects = new ArrayList<MyObject>();

        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; ++i) {
            objects.add(new MyObject(Math.random()));
        }
        System.out.println("Time to create 1.000.000 objects: "
                + Long.toString(System.currentTimeMillis() - start)
                + " ms.");

        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; ++i) {
            objects.get(i).setValue(Math.random());
        }
        System.out.println("Time to reassign 1.000.000 objects: "
                + Long.toString(System.currentTimeMillis() - start)
                + " ms.");

    }

}