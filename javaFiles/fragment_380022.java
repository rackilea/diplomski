@JsonTypeName("amount")
@JsonTypeInfo(include = WRAPPER_OBJECT, use = NAME)
public class Amount {
    private String currency;
    private long minorUnits;
}