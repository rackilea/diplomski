PayPal ppObj = PayPal.initWithAppID(this.getBaseContext(), "APP-80W284485P519543T", PayPal.ENV_SANDBOX);
CheckoutButton launchPayPalButton = ppObj.getPaymentButton(PayPal.BUTTON_278x43, this, PayPal.PAYMENT_TYPE_PERSONAL);
RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
params.addRule(RelativeLayout.BELOW, R.id.refresh);
params.bottomMargin = 10;
launchPayPalButton.setLayoutParams(params);
launchPayPalButton.setOnClickListener(new View.OnClickListener() {


@Override
public void onClick(View v) {
// TODO Auto-generated method stub
PayPalPayment newPayment = new PayPalPayment();
newPayment.setAmount("10.00");
newPayment.setCurrency("USD");
newPayment.setRecipient("");
newPayment.setTax("0.00");
newPayment.setShipping("0.00");
newPayment.setItemDescription("Your Payment");
newPayment.setSenderEmail("");
newPayment.setMerchantName("My Test Store");
Intent paypalIntent = new Intent(getApplicationContext(), PayPalActivity.class);
paypalIntent.putExtra(PayPalActivity.EXTRA_PAYMENT_INFO, newPayment);
UrMoney.this.startActivityForResult(paypalIntent, 1);
}

});
((RelativeLayout)findViewById(R.id.urmoney1)).addView(launchPayPalButton);