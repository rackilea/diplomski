//public void String listCountriesOfOrigin (Bowl[] bowls) {
public static void listCountriesOfOrigin (Bowl[] bowls) {
    for(int i = 0; i < bowls.length; i++) {
        String origin = bowls[i].getOrigin();
        System.out.println(origin);
    }
}