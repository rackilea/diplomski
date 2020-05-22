DateFormat format1 = new SimpleDateFormat("hh:mm:ss");
    try {
        Date date = format1.parse("01:11:22");
        SimpleDateFormat format2 = new SimpleDateFormat("hh:mm a");
        String result = format2.format(date);
        return result;
    } catch (ParseException e) {
        e.printStackTrace();
    }