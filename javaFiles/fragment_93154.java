String foundPattern = null;
String myStringFromInput = editText.getText();
for (String pattern : acceptedPatterns){
  if (myStringFromInput.contains(pattern){
     // we have recognised a java method, flag this up
     foundPattern = pattern;
     break;
  }
}