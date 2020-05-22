String UserInput = "Bar()";
String Prefix = "Foo";

Pattern p = Pattern.compile(Prefix + Pattern.quote(UserInput));

String s1 = "FooBar()";
String s2 = "FooBarNo";

String[] s = { s1, s2};

for (String a : s) {
    Matcher m = p.matcher(a);
    if (m.find())
        System.out.println(a + " ==> Success");
    else
        System.out.println(a + " ==> Failure");
}