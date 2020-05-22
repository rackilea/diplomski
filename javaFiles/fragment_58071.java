class PivotSet {
    private List<Item> item;

    public List<Item> getItem() {
        return item;
    }
    public void setItem(List<Item> item) {
        this.item = item;
    }
}

class Item {
    private List<Column> column;

    public List<Column> getColumn() {
        return column;
    }
    public void setColumn(List<Column> column) {
        this.column = column;
    }
}

class Column {
    private String name;
    private String value;

    @XmlAttribute
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @XmlValue
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}