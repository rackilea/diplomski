class SubClass extends SomeClass<Event> {

    @Override
    public void setValue (Event value) {    // Correct now!
        this.value = value;
    }
}