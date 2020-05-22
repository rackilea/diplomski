private TimeZone extractCalendarTimeZoneComponent(Calendar cal,TimeZone calTz) {
    try {
        for(Component component : cal.getComponents().getComponents("VTIMEZONE")) {
        VTimeZone v = (VTimeZone) component;
           v.getTimeZoneId();
           if(calTz==null) {
               calTz = TimeZone.getTimeZone(v.getTimeZoneId().getValue());
           }
        }
    } catch (Exception e) {
        log.warn("Unable to determine ical timezone", e);
    }
    return null;
}