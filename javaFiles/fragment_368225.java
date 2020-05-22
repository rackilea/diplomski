String s = "ABCDE1234F"; // get your editext value here
Pattern pattern = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}");

Matcher matcher = pattern.matcher(s);
// Check if pattern matches 
if (matcher.matches()) {
  Log.i("Matching","Yes");
}   

[A-Z]{5} - match five literals which can be A to Z
[0-9]{4} - followed by 4 numbers 0 to 9
[A-Z]{1} - followed by one literal which can A to Z