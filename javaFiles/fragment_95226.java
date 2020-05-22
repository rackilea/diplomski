public static class CountryXmlAdapter extends XmlAdapter<String, Country> {

    @Override
    public Country unmarshal(String v) throws Exception {
        Country c =  new Country();
        c.setName(v);
        return c;
    }

    @Override
    public String marshal(Country v) throws Exception {
        return v != null ? v.getName() : null;
    }
}