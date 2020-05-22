class SubClass extends SomeClass {

    @Override
    public void setValue (Event value) {    // Fail! It is not overriding the super class' method.
        this.value = value;    // Warning! Unchecked types (maybe inconsistent).
    }
}