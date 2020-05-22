DateFormat f = getDateTimeInstance(FULL, FULL, new Locale("nl_NL"));
    SimpleDateFormat sf = (SimpleDateFormat) f;
    String p1 = sf.toPattern();
    String p2 = sf.toLocalizedPattern();

    System.out.println( p1 );
    System.out.println( p2 );