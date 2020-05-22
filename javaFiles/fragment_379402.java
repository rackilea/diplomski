public static void testIt(String sample) {
    System.out.print(sample+" ");

    Pattern pattern = Pattern.compile("\\s*([RQrq1-6])\\s*");
    Matcher matcher = pattern.matcher(sample);

    if (matcher.matches()) {
        System.out.println("match '"+matcher.group(1)+"'");
    } else {
        System.out.println("fail");
    }
}