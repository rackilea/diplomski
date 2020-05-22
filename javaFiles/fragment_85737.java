public static void main(final String[] args) {
        final String dateStr = "الأحد 11 يناير 2015 - 20:40";
        try {
            final Date date = new SimpleDateFormat(("EEEE dd MMM yyyy - HH:mm"), new Locale("ar", "MA"))
                    .parse(dateStr);
            System.out.println(date);
        } catch (final ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }