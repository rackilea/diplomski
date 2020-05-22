targetSubstring = targetSubstring.toUpper ();
for (int i = 0; i < namesArray.length; i++) {
  String theName = namesArray[i].getName();
  if (theName.toUpper ().contains(targetSubstring))
  {
    displayArea.append("\n" + theName + "      " + namesArray[i].bestDecade());
  }
 }