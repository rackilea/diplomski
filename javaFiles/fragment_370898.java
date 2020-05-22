class Item {
    private String name;
    private String functionName;
    public Item() {
    }
    public Item(String name) {
        this.name = name;
    }
    public Item(String name, String functionName) {
        this.name = name;
        this.functionName = functionName;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFunctionName() {
        return this.functionName;
    }
    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }
    @Override
    public String toString() {
        return "Item [name=" + this.name + ", functionName=" + this.functionName + "]";
    }
}