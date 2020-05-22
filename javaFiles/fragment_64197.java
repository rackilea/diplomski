System.out.println(replaceSpecial("foo 123 56 78 bar 12 32 abc 000_00"));
System.out.println(replaceSpecial("0000"));
System.out.println(replaceSpecial("any text 00 00 more texts"));
System.out.println(replaceSpecial("any text 000 00 more texts 00"));
System.out.println(replaceSpecial("any text 000 00 more texts 00 00"));
System.out.println(replaceSpecial("any text 00-00 more texts 00_00"));