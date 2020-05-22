ccp.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
   @Override
   public void onCountrySelected() {
      countryCode = ccp.getSelectedCountryCode();
      phoneNumberEditText.setText(countryCode);
 }
});