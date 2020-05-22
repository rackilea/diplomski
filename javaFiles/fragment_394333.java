public static void main(String[] args) {
    try {
        Date date = sdf.parse(dateInString);
    } catch (ParseException e) {
        // do proper thing here like try another
        // format or log/rethrow/wrap exception
    }
}