public static int[] multiply(String term1, String term2)
{
    int[] t1 = parse(term1);
    int[] t2 = parse(term2);
    int[] ret = new int[2];
    ret[0] = t1[0] * t2[0];
    ret[1] = t1[1] + t2[1];
    return ret;
}

public static int[] parse(String term)
{
    int pos = term.indexOf("x^");
    String coeffStr = term.substring(0, pos);
    int coeff = Integer.parseInt(coeffStr);
    String powerStr = term.substring(pos + 2);
    int power = Integer.parseInt(powerStr);
    int[] ret = new int[2];
    ret[0] = coeff;
    ret[1] = power;
    return ret;
}