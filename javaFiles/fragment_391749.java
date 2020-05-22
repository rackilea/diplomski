@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("paymentTransactionNotification")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentTransactionNotification {
  private AmountTransaction amountTransaction;
.............
}