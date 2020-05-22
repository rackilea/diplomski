String myString = "something + {SomeProductSet1}.count + {SomeOtherProductSet2}.amount > \n" +
                "    {SomeProductSet3}.count + {SomeUSOC4}.amount";
Matcher match = Pattern.compile("\\{([^}]+)\\}").matcher(myString);
while(match.find()) {
    System.out.println(match.group(1));    
}