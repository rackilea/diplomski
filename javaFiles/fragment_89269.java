public class CardHolder {
  public final String cardNumber, issuingBank, cardSwitch, cardType;

  public CardHolder(String[] record) {
    int i = 0;
    cardNumber = record[i++];
    issuingBank = record[i++];
    cardSwitch = record[i++];
    cardType = record[i++];
  }
}