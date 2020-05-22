StringBuilder sb = new StringBuilder();
for(int i = 1; i <= doubleLength; i++) {
    doubleRate = (doubleBalance * (doubleRate/100))/12;
    doubleBalance = doubleBalance + doubleRate;
    doublePayment = (doubleBalance/doubleCount);

    sb.append(doublePayment);
    sb.append(" ");

    doubleCount = doubleCount - 1;
    doubleBalance -= doublePayment;
}
TextView results = (TextView) findViewById(R.id.showResult);
results.setText(sb.toString());