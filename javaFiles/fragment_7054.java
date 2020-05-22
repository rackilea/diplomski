System.out.println("Assuming US Locale: " + 
                             "',' as thousand separator, " + 
                             "'.' as decimal separator   ");

    NumberFormat nf = new DecimalFormat("#,##0.0##");
    System.out.println("\n==============================");
    System.out.println("With Format (#,##0.0##) ");
    System.out.println("------------------------------");
    System.out.println("1234.0 = " + nf.format(1234.0));
    System.out.println("123.4  = " + nf.format(123.4));
    System.out.println("12.34  = " + nf.format(12.34));
    System.out.println("1.234  = " + nf.format(1.234));
    System.out.println("==============================");

    nf = new DecimalFormat("#,000.000");
    System.out.println("\n==============================");
    System.out.println("With Format (#,000.000) ");
    System.out.println("------------------------------");
    System.out.println("1234.0 = " + nf.format(1234.0));
    System.out.println("123.4  = " + nf.format(123.4));
    System.out.println("12.34  = " + nf.format(12.34));
    System.out.println("1.234  = " + nf.format(1.234));
    System.out.println("==============================");