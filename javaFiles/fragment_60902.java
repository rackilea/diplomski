try {
        Geocoder geocoder;
        String city=null;
        List<Address> yourAddresses;
        geocoder = new Geocoder(this, Locale.getDefault());
        yourAddresses = geocoder.getFromLocation(yourLatitude, yourLongitude, 1);


    final String yourAddress = yourAddresses.get(0).getAddressLine(0);
    if (yourAddresses != null && yourAddresses.size() > 0) {
        android.location.Address address = yourAddresses.get(0);
        @SuppressWarnings("MismatchedQueryAndUpdateOfStringBuilder") StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
            sb.append(address.getAddressLine(i)).append("\n");
        }
        city = address.getLocality();
        Log.d("city", "onCreate: "+city);
    }

    } catch (IOException e) {
        e.printStackTrace();
    }