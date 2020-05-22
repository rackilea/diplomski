public  String FormatDate(String dateString) {

        try {
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date d = sd.parse(dateString);
            sd = new SimpleDateFormat("yyyy-MMM-dd");
            System.out.println(sd.format(d));
            return sd.format(d);
        } catch (Exception e) {
        }
        return "";
    }