/**
     * Returns localtime for UTC
     *
     * @param date
     * @return
     */
    public static Date timezoneAwareDate(String date){
        // create simpledateformat for UTC dates in database
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        Date output;
        // parse time
        try{
            output = simpleDateFormat.parse(date);
        }catch (Exception e){
            // return current time
            output = new Date();
        }

        return output;
    }