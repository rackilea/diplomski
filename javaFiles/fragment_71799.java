@RooEntity
Class X {
    @NotNull
    @Basic
    private String localeString;



    ....
   public Locale getLocaleFromString() {
        return new Locale(localeString);
   }
}