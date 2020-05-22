public enum EnumWithValueOf {

    VALUE_1("A"), VALUE_2("B"), VALUE_3("C");

    private  String textValue;

    EnumWithValueOf(String textValue) {
        this.textValue = textValue;
    }

    public static EnumWithValueOf textValueOf(String textValue){

        for(EnumWithValueOf value : values()) {
            if(value.textValue.equals(textValue)) {
                return value;
            }
        }

        throw new IllegalArgumentException("No EnumWithValueOf
                            for value: " + textValue);  
    }   
}