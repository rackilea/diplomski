abstract class MyObject {

    abstract Object get ();

    accept (MyObjectsVisitor v) {
        v.visit( this );
    }
}

class MyInteger extends MyObject {
    private int value;

    MyInteger (int value) {
        this.value = value;
    }

    Object get () {
        return Integer.valueOf(this.value);
    }

    accept (MyObjectsVisitor v) {
        v.visit( this );
    }
}

class MyString extends MyObject {
    private String value;

    MyString (String value) {
        this.value = value;
    }

    Object get () {
        return this.value;
    }

    accept (MyObjectsVisitor v) {
        v.visit( this );
    }
}

class MyLong extends MyObject {
    private long value;

    MyLong (long value) {
        this.value = value;
    }

    Object get () {
        return Long.valueOf(this.value);
    }
}