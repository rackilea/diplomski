private final IntegerProperty year; // prevent accidental replacement and adhere to java naming conventions
...

public RecordData(int id, String name, String artist, int year, String genre, double price, int rating) {
    ...
    this.year = new SimpleIntegerProperty(year);
    ...
}

public int getYear() {
    return year.get();
}

public void setYear(int value) {
    year.set(value);
}

public IntegerProperty yearProperty() {
    return year;
}