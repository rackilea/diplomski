//---------------------
    public boolean removeCountry(Country country) {

        Iterator<Country> iterator = countries.iterator();
        while (iterator.hasNext()) {
            Country value = iterator.next();
            if (country.CountryId.equals(value.CountryId) || country.CountryName.equals(value.CountryName)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
//--------------------