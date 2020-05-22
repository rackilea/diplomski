public class Derived extends Base{
    public String getAdditionalProperty(){
        return additionalProperty;
    }
    private String additionalProperty = "value-not-to-serialize";
}