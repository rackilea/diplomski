public class PreferencesAdapter extends XmlAdapter<Preference, HashMap<String, String>> {

    @XmlRootElement
    public static class Preference {
        public String language;
        public String country;
    }

    @Override
    public HashMap<String, String> unmarshal(Preference p) throws Exception {
        HashMap<String, String> map = new HashMap<>();
        map.put("language", p.language);
        map.put("country", p.country);
        return map;
    }


    @Override
    public Preference marshal(HashMap<String, String> v) throws Exception {
        Preference p = new Preference();
        p.language = v.get("language");
        p.country = v.get("country");
        return p;
    }
}