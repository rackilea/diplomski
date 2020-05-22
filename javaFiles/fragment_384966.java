class BagOfPrimitives {
    private int value1;
    private String value2;
    private transient int value3;
    public BagOfPrimitives(int value1, String value2, int value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }
}

BagOfPrimitives obj1 = new BagOfPrimitives(1, "abc", 3);
BagOfPrimitives obj2 = new BagOfPrimitives(32, "gawk", 500);
List<BagOfPrimitives> list = Arrays.asList(obj1, obj2);
Gson gson = new Gson();
String json = gson.toJson(list);  
// Now json is [{"value1":1,"value2":"abc"},{"value1":32,"value2":"gawk"}]