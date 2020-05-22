public enum AutoMake {
    HONDA("Honda", "Japan"),
    TOYOTA("Toyota", "Japan"),
    VW("Volkswagon", "Germany");

    private String country;
    private String text;

    private AutoMake(String text, String country) {
        this.text = text;
    }

    public static AutoMake getMake(String str){
        AutoMake make = null;
        AutoMake[] possible = AutoMake.values();
        for(AutoMake m : possible){
            if(m.getText().equals(str)){
                    make = m;
            break;
            }
        }
        return make;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

}