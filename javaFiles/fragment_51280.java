public static void main(String[] args) {

    String polynomial = "3x^3-x^2+5.9x-3.8";
    String monomialFormat = "([+-]?[\\d\\.]*[a-zA-Z]?\\^?\\d*)", monomialPartsFormat = "([+-]?[\\d\\.]*)([a-zA-Z]?)\\^?(\\d*)";

    Pattern p1 = Pattern.compile(monomialFormat);
    Matcher m1 = p1.matcher(polynomial);

    while (!m1.hitEnd()) {
        m1.find();
        Pattern p2 = Pattern.compile(monomialPartsFormat);
        System.out.print(m1.group() + "   ->   ");
        Matcher m2 = p2.matcher(m1.group());

        if (m2.find()) {     

            float coefficient;
            try {
                String coef = m2.group(1);
                if (isNumeric(coef)) {
                    coefficient = Float.valueOf(coef);
                } else {
                    coefficient = Float.valueOf(coef + "1");
                }
            } catch (IllegalStateException e) {
                coefficient = 0.0F;
            }

            int exponent;
            try {
                String exp = m2.group(3);
                if (isNumeric(exp)) {
                    exponent = Integer.valueOf(exp);
                } else {
                    exponent = 1;
                }
            } catch (IllegalStateException e) {
                exponent = 0;
            }

            String variable = m2.group(2);

            System.out.println("" + coefficient + variable + "^" + exponent);
        }
    }
}

public static boolean isNumeric(String str) {

    return str.matches("[+-]*\\d*\\.?\\d+");
}