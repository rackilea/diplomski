Locale aLocale;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            aLocale = new Locale.Builder().setLanguage("RU").setScript("Latn").setRegion("RS").build();
        } else {
            aLocale = new Locale("RU");
        }
        Geocoder geocoder = new Geocoder(this, aLocale);
        List<Address> addressList = geocoder.getFromLocation(lat, lng, 1);