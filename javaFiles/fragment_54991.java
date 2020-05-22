public class RegExpOrders {

    private Pattern p = Pattern.compile("^((cancel)\\s+(\\w+))|((\\w+)\\s+(buy|sell)\\s+(\\d+)\\s+(\\d+))$");

    public static void main(String[] args) {

        final RegExpOrders regExpOrders = new RegExpOrders();

        System.out.println("should be ok:");
        regExpOrders.check("aa buy 10 10");
        regExpOrders.check("bb buy 2 9");
        regExpOrders.check("cc sell 11 10");
        regExpOrders.check("cancel aa");
        regExpOrders.check("sadkjdscxf buy 30 20");

        System.out.println("should not be ok:");
        regExpOrders.check("cancel aa aabc");
        regExpOrders.check("asdfhdsajhfdsa");
        regExpOrders.check("aa buys 10 10");
        regExpOrders.check("aa buy 12 10 2");
        regExpOrders.check("aa buy 12a 10");
        regExpOrders.check("aa bsell 5 1");
    }

    private void check(String s) {
        final Matcher matcher = p.matcher(s);

        final boolean result = matcher.matches();
        System.out.println("checking (" + s + "): " + result);
        if (result) {
            // group 0 is the whole pattern
            // group 1 the cancel or buy/sell part

            if ("cancel".equals(matcher.group(2))) {
                System.out.println("  cancel order");
                System.out.println("    order-id: " + matcher.group(3));
            } else {
                System.out.println("  exec order");
                System.out.println("    order id: " + matcher.group(5));
                System.out.println("    action: " + matcher.group(6));
                System.out.println("    amount: " + matcher.group(7));
                System.out.println("    price: " + matcher.group(8));
            }
        }
    }
}