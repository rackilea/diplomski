public class Data {

    private String field1 = "hello";

    private Integer field2 = 10;

    private Double field3 = 3.75;

    private static final Data DEFAULTS = new Data(); // defaults will be kept here

    public String getField1() {
        return this.field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public Integer getField2() {
        return this.field2;
    }

    public void setField2(Integer field2) {
        this.field2 = field2;
    }

    public Double getField3() {
        return this.field3;
    }

    public void setField3(Double field3) {
        this.field3 = field3;
    }

    @Override
    public String toString() {
        return "Data [field1=" + this.field1 + 
                   ", field2=" + this.field2 + 
                   ", field3=" + this.field3 + "]";
    }

    public boolean isDefault(Function<Data, Object> getter) {
        Object defaultProperty = getter.apply(DEFAULTS);
        Object actualProperty = getter.apply(this);
        return defaultProperty != null // needed to support fields with no default value
            && defaultProperty.equals(actualProperty);
    }

    public boolean isNull(Function<Data, Object> getter) {
        return getter.apply(this) == null;
    }

    public boolean isSet(Function<Data, Object> getter) {
        return !this.isNull(getter) && !this.isDefault(getter);
    }
}