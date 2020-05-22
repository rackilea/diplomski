static String[] toRange(String str) {
    IPAddressString string = new IPAddressString(str);
    IPAddress addr = string.getAddress();
    System.out.println("starting with CIDR " + addr);
    IPAddress lower = addr.getLower(), upper = addr.getUpper();
    System.out.println("range is " + lower + " to " + upper);
    return new String[] {lower.toString(), upper.toString()};
}