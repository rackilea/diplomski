String text = String.join("\n",
    "ERROR java.lang.NullPointerException: Sample Java Logback Exception",
    "at Sample.errorLevel3(Sample.java:35)",
    "at Sample.errorLevel4(Sample.java:34)",
    "at Sample.errorLevel5(Sample.java:30)",
    "at Sample.errorLevel6(Sample.java:3)"
);
String pattern = "(?:^.*\\s([^:,\\s]+):\\s+([^:\\n]+)|\\G(?!\\A))\\s*at\\s+(\\S+)\\((\\w+\\.\\w+):(\\d+)\\)$";
Pattern regex = Pattern.compile(pattern, Pattern.MULTILINE);
Matcher m = regex.matcher(text);
int matchNum = 0;

//Loop matches
while (m.find())
{
    matchNum++;

    // Loop groups
    for (int i = 1; i <= m.groupCount(); i++) 
    {
        if (m.group(i) != null) {
            System.out.println("Match " + matchNum + " - Group " + i + ": " + m.group(i));
        }
    }
}