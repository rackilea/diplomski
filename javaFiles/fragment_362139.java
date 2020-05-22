public class RecurringDetailsResult implements java.io.Serializable {

    private Date creationDate;
    private String shopperReference;
    private List<RecurringDetailWrapper> details;
    private String lastKnownShopperEmail;

    // getters and setters here. No need for any @JsonGetter or @JsonSetter annotations
}


@JsonRootName("RecurringDetail")
public class RecurringDetailWrapper {

    @JsonProperty("RecurringDetail")
    RecurringDetail recurringDetail;

    public RecurringDetail getRecurringDetail() {
        return recurringDetail;
    }

    public void setRecurringDetail(RecurringDetail recurringDetail) {
        this.recurringDetail = recurringDetail;
    }
}


public class RecurringDetail implements java.io.Serializable {
    private static final long serialVersionUID = 5302883242997268343L;

    private String name;
    private Date creationDate;
    private Card card;
    private AdditionalData additionalData;
    private String socialSecurityNumber;
    private String recurringDetailReference;
    private String alias;
    private String aliasType;
    private String variant;
    private String paymentMethodVariant;
    private String firstPspReference;
    private List<String> contractTypes;
    private String acquirer;
    private String acquirerAccount;

    public class AdditionalData {
        String cardBin;

        public String getCardBin() {
            return cardBin;
        }

        public void setCardBin(String cardBin) {
            this.cardBin = cardBin;
        }
    }

    // getters and setters here. No need for any @JsonGetter or @JsonSetter annotations

}