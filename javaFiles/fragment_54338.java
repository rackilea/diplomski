String patternString = "^KYC[0-9]{6}L$";
Pattern p = Pattern.compile(patternString);
String test = jTextField.getText();
Matcher m = p.matcher(test);
boolean matches = m.matches();
if(matches == true)
  // allow
else
  // JOptionpane.showMessageDialog ---> your desired error message.