IPAddressString addrString = new IPAddressString("2001:cdba::3257:9652");
    IPAddress addr = addrString.getAddress();
    String string = addr.toFullString();
    System.out.println(string);
    string = addr.toCanonicalString();
    System.out.println(string);