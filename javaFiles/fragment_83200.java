private final ZoneId GLASSFISH_HOME_TIME_ZONE = ZoneId.of(FacesContext.getCurrentInstance().getExternalContext().getInitParameter( "GLASSFISH_HOME_TIME_ZONE"));
private ZonedDateTime dateToUseInGlassfish = null;

public DataBean (
    Timestamp dateFromMySQL) 
{
    if ( dateFromMySQL == null ) {
        this.dateToUseInGlassfish = null;
    } else {
        this.dateToUseInGlassfish = LocalDateTime.ofInstant(dateFromMySQL.toInstant(), GLASSFISH_HOME_TIME_ZONE ).atZone( GLASSFISH_HOME_TIME_ZONE );
    }
}

/** Formatter for Date/Time */
private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy ' at ' h:mm a z");

/** Formatter for Date only */
private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

/** Get the date string formatted with date and time */
public String getDateToUseInGlassfishDateTimeFormatted() {
    if ( dateToUseInGlassfish == null ) { return null; }
    String formattedDate = dateTimeFormatter.format( dateToUseInGlassfish );
    return formattedDate;
}

/** Get the date string formatted with date only */
public String getgetDateToUseInGlassfishDateFormatted() {
    if ( dateToUseInGlassfish == null) { return null; }
    String formattedDate = dateFormatter.format( dateToUseInGlassfish );
    return formattedDate;
}

/** Get the date ZDT formatted (for calculations) */
public ZonedDateTime getgetDateToUseInGlassfish() {
    return dateToUseInGlassfish;
}

/** Get the date as Date (for component libraries that automatically fetch then throw up with ZDT) */
public Date getDateToUseInGlassfishDate() {
    if ( dateToUseInGlassfish == null) { return null; }
    return Date.from( dateToUseInGlassfish.toInstant());
}

/** Set the date from ZDT (results from calculations stored in bean) */
public void setDateToUseInGlassfish( ZonedDateTime dateToUseInGlassfish ) {
    this.dateToUseInGlassfish = dateToUseInGlassfish;
}

/** Set the date from Date with an automatic convert to ZDT */
public void setDateToUseInGlassfish( Date dateToUseInGlassfish ) {
    if (dateToUseInGlassfish == null) {
        this.dateToUseInGlassfish = null;
    } else {
        this.dateToUseInGlassfish = LocalDateTime.ofInstant( Instant.ofEpochMilli( dateToUseInGlassfish.getTime()), GLASSFISH_HOME_TIME_ZONE ).atZone( GLASSFISH_HOME_TIME_ZONE );
    }
}