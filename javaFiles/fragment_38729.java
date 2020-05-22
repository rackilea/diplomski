public static void main(String[] args) throws ParseException
    {
       String input = "02:34:23";
       DateFormat inputFormat = new SimpleDateFormat("HH:mm:ss");
       DateFormat outputFormat = new SimpleDateFormat("'Time:' KK:mm a", Locale.forLanguageTag("es_MX"));
       System.out.println(outputFormat.format(inputFormat.parse(input)));
    }