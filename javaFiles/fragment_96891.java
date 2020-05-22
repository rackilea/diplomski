Locale locale = new Locale(langCode, countryCode);
    geocoder = new Geocoder(this, locale);

    List addresses; 
        try {
            addresses = geocoder.getFromLocation(location.latitude,         location.longitude, 1);
        } 
        catch (IOException | IndexOutOfBoundsException | NullPointerException ex) {
            addresses = null;
        }
        return addresses;