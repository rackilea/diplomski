@Entity
public class Wallet {

  private CreditcardNumb creditcard;

  @Column(name = ..., insertable = false, updatable = false)
  private String creditcardStr;

  ...
}