public static void main(String[] args) throws ParseException {
        String time = "Mon Nov 09 2015 00:00:00 GMT+0530 (India Standard Time)";
        DateFormat inputFormat = new SimpleDateFormat(
                "E MMM dd yyyy HH:mm:ss 'GMT'z", Locale.ENGLISH);
        Date date = inputFormat.parse(time);
        System.out.println(date);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        System.out.println(formatter.format(date));
    }