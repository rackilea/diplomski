public static void main(String[] args) {

    CurrencyConverter one = new CurrencyConverter();

    do{
        System.out.println("Convert dollar to euro/gbp/cad");

        System.out.println("enter euro/gbp/cad");
        System.out.println("");
        Scanner input = new Scanner(System.in);
        String a = input.next();

        String d = enterDollars();

        if( d == null )
            break;

        try {
            double ds = Double.parseDouble(d);
            one.setDollar(ds);

            if( "euro".equalsIgnoreCase(a) )
                System.out.println("Euro:\n€" + one.getCurrencyE());
            else if( "gbp".equalsIgnoreCase(a) )
                System.out.println("GBP:\n£" + one.getCurrencyG());
            else if( "cad".equalsIgnoreCase(a) )
                System.out.println("Canadian Dollar:\n$" + one.getCurrencyC());
        }
        catch (NumberFormatException e) {
            System.out.println("Not double,wrong input");
        }

    } while (true);

}


private static String enterDollars(){
    System.out.println("Enter Dollars:");
    Scanner in = new Scanner(System.in);
    String d = in.next();

    if ("Q".equalsIgnoreCase(d)) {
        System.out.println("Stop!");
        return null;
    } 

    return d;
}