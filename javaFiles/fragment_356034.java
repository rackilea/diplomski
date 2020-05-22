final String testStr = textbox.getText(); //for example
Predicate<String> myCity = new Predicate<String>() {
    @Override public boolean apply(String city) {
        return city.equals(testStr);
    }               
};