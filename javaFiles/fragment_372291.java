public TimeZone getZone(String id) {
        TimeZone tz = TimeZone.getTimeZone();
        if (!tz.getID().equals(id)) {
            throw new IllegalArgumentException("unrecognized zone " + id);
        }
        return tz;
    }