String fullDate = "2015-04-13T10:17:00-04:00";
        String truncatedDate = fullDate.substring(0, fullDate.lastIndexOf('-'));

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss",
                Locale.ENGLISH);
        try {

            Date dte = format.parse(truncatedDate);
            System.out.println("date=" + dte);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }