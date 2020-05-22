String weekLaterOutput = 
    weekLater
    .get( IsoFields.WEEK_BASED_YEAR ) 
    + "-W" 
    + String.format( "%02d" , weekLater.get( IsoFields.WEEK_OF_WEEK_BASED_YEAR ) ) 
    + "-" 
    + weekLater.getDayOfWeek().getValue()
; // Generate standard ISO 8601 output. Ex: 2018-W11-1