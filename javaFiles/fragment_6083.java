public void compute(String displ) {
    Pattern p = Pattern.compile("(\\d+(?:\\.\\d+)?)([+-])(\\d+(?:\\.\\d+)?)");
    for (;;) {
        Matcher m = p.matcher(displ);
        if (!m.find()) {
            break;
        }
        double lhs = Double.parseDouble(m.group(1));
        String op = m.group(2);
        double rhs = Double.parseDouble(m.group(3));
        double result = 0;
        switch (op) {
        case "+":
            result = lhs + rhs;
            break;
        case "-":
            result = lhs - rhs;
            break;
        }
        displ = displ.substring(0, m.start())
            + result
            + displ.substring(m.end());

    }
    System.out.println(displ);
}