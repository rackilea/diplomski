class Item {

    private final String name;
    private final int units;
    private final int result;

    Item(String name, int units, int result) {
        this.name = name;
        this.units = units;
        this.result = result;
    }

    String getName() {
        return name;
    }

    int getUnits() {
        return units;
    }

    int getResult() {
        return result;
    }

}