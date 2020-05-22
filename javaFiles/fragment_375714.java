public static void main(String[] args) {
    String fromDate = "Thu Aug 02 2012 02:00:00 GMT+0200 (Mitteleuropäische Sommerzeit)";
    String fromDateConverted = fromDate.replaceAll("\\+(..)(..)", "+$1:$2");
    System.out.println("ORG: " + fromDate);
    System.out.println("CNV: " + fromDateConverted);
    SimpleDateFormat parseFormat = new SimpleDateFormat("EE MMM dd yyyy HH:mm:ss zzzz", Locale.ENGLISH);

    Date theDate = parseFormat.parse(fromDateConverted);

    // OData Edm.DateTime:
    // yyyy “-” mm “-” dd “T” hh “:” mm [":" ss["." fffffff]]
    SimpleDateFormat outFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.0000000");

    System.out.println("EDM: " + outFormat.format(theDate));
}