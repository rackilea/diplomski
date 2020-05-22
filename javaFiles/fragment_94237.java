String s = "something Line One\n" + 
        "something Line two \n" + 
        "Last annotated on December 31, 2014\n" + 
        "\n" + 
        "I don't care what is in between. Anything can go here. Any number of lines\n" + 
        "I don't care what is in between. Anything can go here. Any number of lines\n" + 
        "\n" + 
        "Something Line three\n" + 
        "something line four\n" + 
        "Last annotated on November 15, 2014";
Matcher m = Pattern.compile(".*[\\r\\n]+.*[\\r\\n]+Last annotated on \\w* \\d{2}, \\d{4}").matcher(s);
while(m.find())
{
    System.out.println(m.group());
}