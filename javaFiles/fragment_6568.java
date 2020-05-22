public String convert(String inputString) {
    SimpleDateFormat inputFormat = new SimpleDateFormat("MMddyyyy");
    SimpleDateFormat outputFormat = new SimpleDateFormat("MMMM d, yyyy");
    Date theDate = inputFormat.parse(inputString);
    return outputFormat.format(theDate);
}