if (jspValue1.getValue() instanceof Double) {
    s = jspValue1.toString();
    d = Double.parseDouble(s);
    return d;
} else {
    return 0.00;
}