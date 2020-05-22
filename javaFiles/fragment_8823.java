Token token = null;

final Card card = new Card(cardNumber, month, year, cvc);

final Stripe stripe = new Stripe(getApplicationContext());
try {

    token = stripe.createTokenSynchronous(card, "pk_test_TYooMQauvdEDq54NiTphI7jx");

} catch (StripeException stripeEx) {

    errorMessage = stripeEx.getLocalizedMessage();
}