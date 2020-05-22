public class DataFieldString extends DataField<String> {

    public DataFieldString(String name, String value) {
        super(name, value);
        //  or the other way : super(new NameAndType<>(name, value));
    }    
   ...
}