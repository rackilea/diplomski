// TEST-ANY
String str = "wordToTest";
int UrangeLow = 1234; // can get range from e.g. http://www.utf8-chartable.de/unicode-utf8-table.pl
int UrangeHigh = 2345;
for(int iLetter = 0; iLetter < str.length() ; iLetter++) {
   int cp = str.codePointAt(iLetter);
   if (cp >= UrangeLow && cp <= UrangeHigh) {
      // word is NOT English
      return;
   } 
}
// word is English
return;