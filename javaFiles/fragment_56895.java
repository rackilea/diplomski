int degree = 1;
Matcher m = Pattern.compile("(?<=\\^)\\d+").matcher(equation);

while (m.find()) {
    int exp = Integer.parseInt(m.group());

    if (exp > degree)
        degree = exp;
}