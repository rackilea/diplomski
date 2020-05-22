class AccentedNamePerson extends Person {
    private String normalised;
    private String normalisedName() {
       if(normalised != null) return normalised;
       normalised = Normalizer.normalize(string, Normalizer.Form.NFD);
       /** assuming input is in unicode. if ascii use .replaceAll("[^\\p{ASCII}]", ""); **/
       normalised  = normalised.replaceAll("\\p{M}", "");
       return normalised;
    }
    @Override
    public boolean matchesName(String name) {
        String
        return this.normalisedName().toLowerCase().indexOf(name.toLowerCase()) > -1;
    }
}