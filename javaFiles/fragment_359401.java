public static void main(String[] args) {
    Double d = 20150616.0000328;
    System.out.println("exponential = " + d);

    String formatMask = "0.################################################";
    DecimalFormat df = new DecimalFormat(formatMask);

    System.out.println("normal number=" + df.format(d));
}