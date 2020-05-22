String COMMA_INSIDE = ",(?=[^()]*\\))";
    String text = "a, b, c, (d, e, f), g, h, (i, j, k)";
    System.out.println(
        text.replaceAll(COMMA_INSIDE, " OR")
    );
    // a, b, c, (d OR e OR f), g, h, (i OR j OR k)