this.firstName = new SimpleStringProperty(firstName) {

    @Override
    public void set(String value) {
        super.set(value);
        System.out.println("first name updated (SimpleStringProperty.set)");
    }

};