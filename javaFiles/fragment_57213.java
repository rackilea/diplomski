Pattern pattern = Pattern.compile("Class: (.+?)\nFrom: (.+?) To: (.+?)\nOccures: (.+?) In: (.+?) (.+?)");
Matcher matcher = pattern.matcher(yourInputString);
if (matcher.find())
{
     String data1 = matcher.group(1);
     String data2 = matcher.group(2);
     String data3 = matcher.group(3);
     String data4 = matcher.group(4);
     String data5 = matcher.group(5);
     String data6 = matcher.group(6);
} else
{
    // String didn't match the specified format
}