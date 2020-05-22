public static class Item {

    private final StringProperty nameProp = new SimpleStringProperty();
    private final StringProperty numberProp = new SimpleStringProperty();

    Item(String n, String num) {
        nameProp.set(n);
        numberProp.set(num);
    }

    public String getName() {
        return nameProp.get();
    }

    public void setName(String name) {
        nameProp.set(name);
    }

    public StringProperty nameProperty() {
        return nameProp;
    }

    public String getNumber() {
        return numberProp.get();
    }

    public void setNumber(String number) {
        numberProp.set(number);
    }

    public StringProperty numberProperty() {
        return numberProp;
    }
}