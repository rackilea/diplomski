AttributedString s = new AttributedString("Hello");
    AttributedCharacterIterator x = s.getIterator();
    String a = "";

    a+=x.current();
    while (x.getIndex() < x.getEndIndex())
        a += x.next();
    a=a.substring(0,a.length()-1);

    System.out.println(a);