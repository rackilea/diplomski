class A implements Cloneable {

    public A clone() {

        A obj = (A) super.clone();

        // Do some deep-copying of fields

        return obj;
    }

}

class B extends A {

    public B clone() {

        B obj = (B) super.clone();

        // Do some deep-copying of fields not known to A

        return obj;

    }
}