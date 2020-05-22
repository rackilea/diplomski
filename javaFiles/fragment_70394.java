String s = "123456abc:de234567:c567890d";
StringBuilder result = new StringBuilder();
Pattern pattern = Pattern.compile("(?<!\\d)\\d{6}(?!\\d)");  // Pattern to match 6 digit chunks not enclosed with digits
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    if (result.length() == 0)  {              // If the result is empty
        result.append(matcher.group(0));      // add the 6 digit chunk
    } else {
       result.append("-").append(matcher.group(0)); // else add a delimiter and the digits after it
    }
} 
System.out.println(result.toString());      // Demo, use this to write to your new column