public void calculateTimeZone(Context context) {
    float ONE_HOUR_MILLIS = 60 * 60 * 1000;

    // Current timezone and date
    TimeZone timeZone = TimeZone.getDefault();
    Date nowDate = new Date();
    float offsetFromUtc = timeZone.getOffset(nowDate.getTime()) / ONE_HOUR_MILLIS;

    // Daylight Saving time
    if (timeZone.useDaylightTime()) {
        // DST is used
        // I'm saving this is preferences for later use

        // save the offset value to use it later
        float dstOffset = timeZone.getDSTSavings() / ONE_HOUR_MILLIS;
        // DstOffsetValue = dstOffset
        // I'm saving this is preferences for later use

        // save that now we are in DST mode
        if (timeZone.inDaylightTime(nowDate)) {
            // Now you are in use of DST mode
            // I'm saving this is preferences for later use
        } else {
            // DST mode is not used for this timezone
            // I'm saving this is preferences for later use
        }
    }
}