package test;

import java.util.Vector;

class Vectimplement {

@SuppressWarnings("unchecked")
public static void main(String[] args) {
    @SuppressWarnings("rawtypes")
    Vector v = new Vector();
    v.add("element_1");
    v.add("element_2");
    v.add("element_3");
    v.addElement("New Element");
    System.out.println("Elements in Vector :");
    for (int i = 0; i < v.size(); i++) {
        System.out.println(v.get(i));
    }
}
}