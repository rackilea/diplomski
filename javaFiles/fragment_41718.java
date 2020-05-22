public DecimalFormat getDecimalFormat(int decimals) {
    StringBuilder sb = new StringBuilder(decimals + 2);
    sb.append("#.");
    for(int i = 0; i < decimals; i++) {
        sb.append("0");
    }
    return new DecimalFormat(sb.toString());
}