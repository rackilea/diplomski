@Entity
    @Table(name = "moneyAmountAndCurrency")
    @TypeDef(name = "testjoda_MoneyAmountWithCurrencyType", typeClass = PersistentMoneyAmountAndCurrency.class)
    public class MoneyAmountAndCurrencyHolder implements Serializable {

    private static final long serialVersionUID = -1674416082110551506L;

    @Columns(columns = { @Column(name = "MY_CURRENCY"), @Column(name = "MY_AMOUNT") })
    @Type(type = "testjoda_MoneyAmountWithCurrencyType")
    private Money money;