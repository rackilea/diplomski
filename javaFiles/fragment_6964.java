public class User {

    // fields, accessors and mutators

    public void addPaymentDetails(CardInfo cardInfo) {
        if (paymentDetails == null) {
            paymentDetails = new LinkedHashSet<>();
        }
        if (cardInfo.getUser() != this) {
            cardInfo.setUser(this);
        }
        paymentDetails.add(cardInfo);
    }

}