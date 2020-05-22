public static class CustomEnum {
    private static final Map<String,CustomEnum> valuesMap = new LinkedHashMap<>();
    private static final List<CustomEnum> valuesList = new ArrayList<>();
    private final String data;

    public CustomEnum(String data) {
        this.data = data;
    }

    public CustomEnum valueOf(final String data){
        if (data == null) {
            throw new NullPointerException();
        }
        final CustomEnum customEnum = valuesMap.get(data);
        if(customEnum == null){
            throw new IllegalArgumentException();
        }
        return customEnum;
    }

    public CustomEnum[] values(){
        return valuesList.toArray(new CustomEnum[valuesList.size()]);
    }

    public int ordinal(){
        return valuesList.indexOf(this);
    }

    public static void create(String...data) {
        for(String s : data){
            final CustomEnum customEnum = new CustomEnum(s);
            valuesMap.put(s, customEnum);
            valuesList.add(customEnum);
        }
    }
}

public void test(String[] args) {
    CustomEnum.create("white");
}