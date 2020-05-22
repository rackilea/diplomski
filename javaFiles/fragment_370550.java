class SubClass extends SomeClass<String> {

    @Override
    public void setValue (Event value) {    // Fail! Not overriding.
        this.value = value;    // Fail! Inconsistent types.
    }
}