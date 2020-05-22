Pattern p = Pattern.compile("(\\w+)=\"*((?<=\")[^\"]+(?=\")|([^\\s]+))\"*");

String test = "a0=d235 a1=2314 com1=\"abcd\" com2=\"a b c d\"";
Matcher m = p.matcher(test);

while(m.find()){
    print m.group(1);
    print "="
    println m.group(2);
}