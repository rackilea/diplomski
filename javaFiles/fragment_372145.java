public static void main(String[] args) {
    String s = "2.22234242342342";
    double d = Double.parseDouble(s);
    DecimalFormat decimal = new DecimalFormat("#.00%");
    System.out.println(s);
    System.out.println(decimal.format(d));
}