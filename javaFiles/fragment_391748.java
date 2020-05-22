@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("amountTransaction")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AmountTransaction {
    private String clientCorrelator;
    private String endUserId;
...............
}