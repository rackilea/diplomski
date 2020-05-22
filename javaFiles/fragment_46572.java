public class SomeData {
    int id;
    SomePojo jsonField;

    @JsonSerialize(using = PojoSerializer.class)
    public SomePojo getJsonField(){
         return jsonField;
    }
}