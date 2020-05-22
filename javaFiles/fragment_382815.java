try { 
    if (!s.toString().equals("") && !priceShow.getText().toString().equals("")) {
        myPercent = Double.parseDouble(s.toString());
        myPrice =  Double.parseDouble(priceShow.getText().toString());
        finalPrice = myPrice*(myPercent/100);
        priceAfterDiscount.setText(String.valueOf(finalPrice));
    }
} catch (NumberFormatException e) {
    e.printStackTrace();
}