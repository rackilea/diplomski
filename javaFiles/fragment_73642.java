String patternString = "block1:([^:]*)";
String[] tests = {":test:block1:%a1%a2%a3%a4:block2:BL",
                  ":test:block2:BL:block1:%a1%a2%a3%a4"};
for (int i=0; i<tests.length; i++)
{
    Pattern p = Pattern.compile(patternString, Pattern.DOTALL);
    Matcher m = p.matcher(tests[i]);
    if(m.find())
    {
        System.out.println(tests[i] + " matched. Match: " +
                    m.group(0) + ", Group 1: " + m.group(1));
    }
}