public enum DtoType{

    TYPE1(1), TYPE2(2),... TYPE7(7)

    private final String value;

    DtoType(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }