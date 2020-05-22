public enum MyClass {
    ONE(INSTANCE_1_DATA_FILE),
    TWO(INSTANCE_2_DATA_FILE),
    //etc...

    private MyClass(String dataFile)
    {
       this(getNameFromDataFile(dataFile), other values...)
    }

    private MyClass(String name, String data, etc...)
    {
       this.name = name;
       // etc..
    }

    public String getName()
    {
        return name;
    }
}