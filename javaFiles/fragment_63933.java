String tmp;
    Scanner reader= new Scanner(System.in).useLocale(Locale.US);
    System.out.print("calculation of the delta. Enter the first number (a from the formula)");
    tmp = reader.next();
    n1 = fractionToDouble(tmp);
    tmp = reader.next();
    n2 = fractionToDouble(tmp);
....