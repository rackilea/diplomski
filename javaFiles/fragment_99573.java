static class GFSCountryList {
    public List<GFSCountry> details;
}

public static List<GFSCountry> get() {
    return new Gson().fromJson(countriesJson, GFSCountryList.class).details;
}