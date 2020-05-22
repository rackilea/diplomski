public static Long ldapTimePeriodToDays(String ldapPeriod) {
    Long ldapPeriodLong = Long.parseLong(ldapPeriod);

    long days = Math.abs(ldapPeriodLong
            / 10_000    //100-nanosecond time slices to milliseconds
            / 1000      //to seconds
            / 60        //to minutes
            / 60        //to hours
            / 24        //to days
    );

    return days;
}