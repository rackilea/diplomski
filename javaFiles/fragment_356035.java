public class CityPredicate implements Predicate<String>{
    String cityName;
    public CityPredicate(String cityName){
        this.cityName = cityName;
    }
    @Override public boolean apply(String city) {
        return city.equals(cityName);
    } 
}
//Use example :
Predicate<String> myCity = new CityPredicate("New York");