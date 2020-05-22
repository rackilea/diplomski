public double convertFrac(int whole, String frac) {
    if (frac == null || frac.equals(""))
        return whole;
    String[] parts = frac.split("/");
    return whole + (double)Integer.parseInt(parts[0]) / (double)Integer.parseInt(parts[1]);
}